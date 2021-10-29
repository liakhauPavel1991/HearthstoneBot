package forms;

import imageTools.Image;
import utils.readers.PropertyReader;
import java.awt.*;

public class Map extends BaseForm{
    private static Point startSearch = new Point(370, 480);
    private static Point finishPoint = new Point(1050, 480);
    private static int step = 80;

    private final int battleLoading = 20000;
    private static final String playBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "playBtn");
    private static final String lookCommandStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "lookCommand");

    private static final String  emptyEnemyImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "emptyEnemyImage");//
    private static final String  redPowerImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "redPowerImage");//
    private static final String  greenPowerImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "greenPowerImage");//
    private static final String  bluePowerImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "bluePowerImage");
    private static final String  portalImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "portalImage");
    private static final String  bombImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "bombImage");//
    private static final String  diversionImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "diversionImage");//
    private static final String  resurrectionImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "resurrectionImage");//
    private static final String  taskerImageStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "taskerImage");//


    private static final Rectangle playBtn = new Rectangle(1500, 830, 20,20);
    private static final Rectangle lookCommand = new Rectangle(700, 990, 20,20);
    private static final Rectangle enemyImage = new Rectangle(1450, 280, 100, 100);


    public void startBattle(){
        waitSimilarPicture(playBtnStr, playBtn);
        robot.move(playBtn);
        sleep(700);
        robot.clickAndClick();
        sleep(battleLoading);
    }

    public boolean isEmptyImage(){
        return isThatImageExist(emptyEnemyImageStr, enemyImage);
    }

    private void clickRightMapEnemy(){
        for (int x = startSearch.x; x < finishPoint.x; x+= step){
            robot.move(new Point(x, startSearch.y));
            robot.click();
        }
    }

    private void clickLeftMapEnemy(){
        for (int x = finishPoint.x; x > startSearch.x; x-= step){
            robot.move(new Point(x, startSearch.y));
            robot.click();
        }
    }

    private int mapEnemyPriority() {
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
    public int findBestEnemy(int j){
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

    private void badScenery(){
        robot.move(playBtn);
        robot.clickAndClick();
        sleep(2300);
        robot.clickAndClick();
    }











}
