package monitorActions;

import imageTools.Image;
import utils.readers.PropertyReader;
import java.awt.*;

interface Map extends BaseForm{
    int timeAnimationMap = 3000;
    Point startSearch = new Point(370, 480);
    Point finishPoint = new Point(1100, 480);

    Point backFromBattle = new Point(1050, 810);
    Point acceptBack = new Point(800, 600);
    int step = 80;

    Rectangle playBtn = new Rectangle(1500, 830, 20,20);
    Rectangle lookCommand = new Rectangle(700, 990, 20,20);
    Rectangle enemyImage = new Rectangle(1450, 280, 100, 100);

    Image  emptyEnemyImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "emptyEnemyImage"), enemyImage);
    Image  redPowerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "redPowerImage"), enemyImage);
    Image  greenPowerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "greenPowerImage"), enemyImage);
    Image  bluePowerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "bluePowerImage"), enemyImage);
    Image  portalImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "portalImage"), enemyImage);
    Image  bombImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "bombImage"), enemyImage);
    Image  diversionImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "diversionImage"), enemyImage);
    Image  resurrectionImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "resurrectionImage"), enemyImage);
    Image  taskerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "taskerImage"), enemyImage);

    Image goBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "goBtn"), playBtn);
    Image playBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "playBtn"), playBtn);
    Image lookCommandStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "lookCommand"), lookCommand);

    default void startBattle(){
        System.out.println("Start Battle");
        sleep(timeCommonAnimation);
        robot.move(playBtn);
        robot.clickAndClick();
    }

    default void waitMapLoading(){
        System.out.println("load Map");
        waitSimilarPicture(lookCommandStr, lookCommand);
        sleep(timeAnimationMap);
    }

    default boolean hasChose(){ // attend showBtnStr-------------------------------
        return !(isSimilar(goBtnStr, playBtn) || isSimilar(playBtnStr, playBtn));
    }

    default EnemyPriority findBestOption(){
        clickLeftMapEnemy();
        EnemyPriority leftEnemyPriority = mapEnemyPriority();
        clickRightMapEnemy();
        EnemyPriority rightEnemyPriority = mapEnemyPriority();
        EnemyPriority bestOption = rightEnemyPriority;
        if(leftEnemyPriority.ordinal() < rightEnemyPriority.ordinal()){
            clickLeftMapEnemy();
            bestOption = leftEnemyPriority;
        }
        return bestOption;
    }

    default void clickRightMapEnemy(){
        for (int x = startSearch.x; x < finishPoint.x; x+= step){
            robot.move(new Point(x, startSearch.y));
            robot.click();
        }
    }

    default void clickLeftMapEnemy(){
        for (int x = finishPoint.x; x > startSearch.x; x-= step){
            robot.move(new Point(x, startSearch.y));
            robot.click();
        }
    }

    default EnemyPriority mapEnemyPriority() {
        EnemyPriority priority;
        if (isSimilar(taskerImageStr, enemyImage)) {
            System.out.println("it is Tasker");
            priority = EnemyPriority.TASKER;
        } else if (isSimilar(resurrectionImageStr, enemyImage)) {
            System.out.println("it is Resurrect");
            priority = EnemyPriority.RESURRECTION;
        } else if (isSimilar(diversionImageStr, enemyImage)) {
            System.out.println("it is Diversion");
            priority = EnemyPriority.DIVERSION;
        } else if (isSimilar(bombImageStr, enemyImage)) {
                System.out.println("it is Bomb");
                priority = EnemyPriority.BOMB;
        } else if (isSimilar(redPowerImageStr, enemyImage) ||
                isSimilar(greenPowerImageStr, enemyImage) ||
                isSimilar(bluePowerImageStr, enemyImage)) {
            System.out.println("it is Extra Power");
            priority = EnemyPriority.EXTRA_POWER;
        }else if (isSimilar(portalImageStr, enemyImage)) {
            System.out.println("it is Portal");
            priority = EnemyPriority.PORTAL;
        }
        else {
            System.out.println("it is Enemy or Empty");
            priority = EnemyPriority.ENEMY;
        }
        return priority;
    }

    default void moveToNextEnemy(){
        robot.move(playBtn);
        robot.clickAndClick();
        sleep(2300);
        robot.clickAndClick();
    }

    default void backFromBattle(){
        robot.move(lookCommand);
        robot.clickAndClick();
        sleep(1200);
        robot.move(backFromBattle);
        robot.clickAndClick();
        sleep(1100);
        robot.move(acceptBack);
        sleep(300);
        robot.clickAndClick();
        sleep(2000);
        robot.clickAndClick(); // взять награды
        sleep(1000);
        robot.clickAndClick();
        sleep(4000);
    }









}
