package forms;

import actions.EnemyPriority;
import imageTools.Image;
import utils.readers.PropertyReader;
import java.awt.*;

public class Map extends BaseForm{
    public static int fightToEnd = 6;

    private static final int timeAnimationMap = 3000;
    private static final Point startSearch = new Point(370, 480);
    private static final Point finishPoint = new Point(1100, 480);
    private static final int step = 80;
    private static final int battleLoading = 20000;

    private static final Rectangle playBtn = new Rectangle(1500, 830, 20,20);
    private static final Rectangle lookCommand = new Rectangle(700, 990, 20,20);
    private static final Rectangle enemyImage = new Rectangle(1450, 280, 100, 100);

    private static final Image  emptyEnemyImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "emptyEnemyImage"), enemyImage);
    private static final Image  redPowerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "redPowerImage"), enemyImage);
    private static final Image  greenPowerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "greenPowerImage"), enemyImage);
    private static final Image  bluePowerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "bluePowerImage"), enemyImage);
    private static final Image  portalImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "portalImage"), enemyImage);
    private static final Image  bombImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "bombImage"), enemyImage);
    private static final Image  diversionImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "diversionImage"), enemyImage);
    private static final Image  resurrectionImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "resurrectionImage"), enemyImage);
    private static final Image  taskerImageStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "taskerImage"), enemyImage);

    private static final Image goBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "goBtn"), playBtn);
    private static final Image playBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "playBtn"), playBtn);
    private static final Image lookCommandStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "lookCommand"), lookCommand);

    public static void startBattle(){
        sleep(timeCommonAnimation);
        robot.move(playBtn);
        robot.clickAndClick();
    }

    public static void findBestEnemy(){
        System.out.println("Find best Enemy");
        waitSimilarPicture(lookCommandStr, lookCommand);
        sleep(timeAnimationMap);

        if( hasChose()){
            System.out.println("I have a chose");
            instructionWhatToDo(findBestOption());
        } else {
            System.out.println("I have not a chose");
            instructionWhatToDo(mapEnemyPriority());
        }
    }

    private static boolean hasChose(){ // attend showBtnStr-------------------------------
        return !(isSimilar(goBtnStr, playBtn) || isSimilar(playBtnStr, playBtn));
    }

        private static void instructionWhatToDo(EnemyPriority whatToDo){
            fightToEnd--;
            switch (whatToDo){
                case TASKER: {
                    startBattle();
                    new GettingTask().getTask();
                    sleep(4000);
                    if(fightToEnd != 0) {
                        findBestEnemy();
                    } else {
                        startBattle();
                    }
                    break;
                }
                case ENEMY: {
                    robot.move(playBtn);
                    robot.clickAndClick();
                    sleep(battleLoading);
                    break;
                }
                case PORTAL: {
                    fightToEnd = 0;
                    moveToNextEnemy();
                    break;
                }
                case RESURRECTION:
                case BOMB:
                case EXTRA_POWER:
                case DIVERSION: {
                    moveToNextEnemy();
                    if(fightToEnd != 0) {
                        findBestEnemy();
                    }
                    break;
                }
            }
        }

    private static EnemyPriority findBestOption(){
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

    private static void clickRightMapEnemy(){
        for (int x = startSearch.x; x < finishPoint.x; x+= step){
            robot.move(new Point(x, startSearch.y));
            robot.click();
        }
    }

    private static void clickLeftMapEnemy(){
        for (int x = finishPoint.x; x > startSearch.x; x-= step){
            robot.move(new Point(x, startSearch.y));
            robot.click();
        }
    }

    private static EnemyPriority mapEnemyPriority() {
        EnemyPriority priority;
        if (isSimilar(taskerImageStr, enemyImage)) {
            System.out.println("it is Tasker");
            priority = EnemyPriority.TASKER;
        } else if (isSimilar(resurrectionImageStr, enemyImage)) {
            System.out.println("it is Resurrect");
            priority = EnemyPriority.RESURRECTION;
        } else if (isSimilar(bombImageStr, enemyImage) ||
                isSimilar(diversionImageStr, enemyImage)) {
            System.out.println("it is Bomb or Diversion");
            priority = EnemyPriority.DIVERSION;
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

    private static void moveToNextEnemy(){
        robot.move(playBtn);
        robot.clickAndClick();
        sleep(2300);
        robot.clickAndClick();
    }











}
