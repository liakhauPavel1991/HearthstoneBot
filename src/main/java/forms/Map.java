package forms;

import imageTools.Image;
import utils.readers.PropertyReader;
import java.awt.*;

public class Map extends BaseForm{
    private static Point startSearch = new Point(370, 480);
    private static Point finishPoint = new Point(1100, 480);
    private static int step = 80;
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

    private static final Image playBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "playBtn"), playBtn);
    private static final Image lookCommandStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "lookCommand"), lookCommand);

    public static void startBattle(){
        waitSimilarPicture(playBtnStr, playBtn);
        sleep(timeAnimation);
        robot.move(playBtn);
        robot.clickAndClick();
    }

    public static int findBestEnemy(int j){
        waitSimilarPicture(playBtnStr, playBtn);
        sleep(timeAnimation);
        if(j<5){
            clickLeftMapEnemy();
            int leftEnemyPriority = mapEnemyPriority();
            clickRightMapEnemy();
            int rightEnemyPriority = mapEnemyPriority();
            int bestOption = rightEnemyPriority;
            if(leftEnemyPriority < rightEnemyPriority){
                clickLeftMapEnemy();
                bestOption = leftEnemyPriority;
            }

            switch (bestOption){
                case 1: { // -----------------> Tasker
                    robot.move(playBtn);
                    robot.click();
                    new GettingTask().getTask();
                    System.out.println("task is got");
                    findBestEnemy(++j);
                    break;
                }
                case 2: { // -----------------> Resurrect
                    badScenery();
                    findBestEnemy(++j);
                    System.out.println("resurrect");
                    break;
                }
                case 3: { // -----------------> Enemy
                    robot.move(playBtn);
                    robot.clickAndClick();
                    sleep(battleLoading);
                    System.out.println("task is got");
                    break;
                }
                case 4:
                case 5:
                case 6: { // -----------------> Bomb, Divers, Power
                    badScenery();
                    findBestEnemy(++j);
                    System.out.println("bomb");
                    break;
                }
            }
        }

        return ++j;
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

    private static int mapEnemyPriority() {
        int priority;
        if (isSimilarImageExist(taskerImageStr, enemyImage)) {
            priority = 1;
        } else if (isSimilarImageExist(resurrectionImageStr, enemyImage)) {
            priority = 2;
        } else if (isSimilarImageExist(bombImageStr, enemyImage) ||
                isSimilarImageExist(diversionImageStr, enemyImage)) {
            priority = 5;
        } else if (isSimilarImageExist(redPowerImageStr, enemyImage) ||
                isSimilarImageExist(greenPowerImageStr, enemyImage) ||
                isSimilarImageExist(bluePowerImageStr, enemyImage)) {
            priority = 4;
        }
        /*else if (isSimilarImageExist(portalImageStr, enemyImage)) {
            priority = 6;//------------------------------------------------------------------------------
        } */
        else {
            priority = 3;
        }
        return priority;
    }


    private static void badScenery(){
        robot.move(playBtn);
        robot.clickAndClick();
        sleep(2300);
        robot.clickAndClick();
    }











}
