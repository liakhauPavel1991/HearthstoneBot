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

    public void findNextEnemy(){
        for (int x = startSearch.x; x < finishPoint.x; x+= step){
            robot.move(new Point(x, startSearch.y));
            robot.click();
            sleep(200);
            if(!isEmptyImage()){
                if(isSimilarImageExist(redPowerImageStr, enemyImage) ||
                isSimilarImageExist(greenPowerImageStr, enemyImage) ||
                isSimilarImageExist(bluePowerImageStr, enemyImage) ||
                isSimilarImageExist(bombImageStr, enemyImage) ||
                isSimilarImageExist(diversionImageStr, enemyImage)||
                isSimilarImageExist(resurrectionImageStr, enemyImage)){
                    robot.move(playBtn);
                    robot.clickAndClick();
                    sleep(2300);
                    robot.clickAndClick();
                    for (int y = finishPoint.x; y > startSearch.x; y -= step){
                        robot.move(new Point(x, startSearch.y));
                        robot.click();
                    }
                    robot.move(playBtn);
                    robot.clickAndClick();
                    sleep(2300);
                    robot.clickAndClick();
                } else if(isSimilarImageExist(taskerImageStr, enemyImage)){
                    new GettingTask().getTask();
                    findNextEnemy();
                } else {
                    robot.move(playBtn);
                    robot.clickAndClick();
                    sleep(battleLoading);
                }
                x = finishPoint.x;
            }
        }
    }



}
