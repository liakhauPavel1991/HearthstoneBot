package forms;

import imageTools.Image;
import utils.readers.PropertyReader;
import java.awt.*;

public class StartPreparing extends BaseForm{
    private static final int timeAnimationButton = 1000;
    private static final Rectangle choseEnemyBand = new Rectangle(1480, 830, 20, 20);
    private static final Image choseEnemyBandObj = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "choseEnemyBand"), choseEnemyBand);

    private static final Rectangle choseCommand = new Rectangle(1440, 880, 20,20);
    private static final Image choseCommandStrStorage = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "choseCommand"), choseCommand);

    public static void choseBattle(){
        waitSimilarPicture(choseEnemyBandObj, choseEnemyBand);
        sleep(timeAnimationButton);
        robot.move(choseEnemyBand);
        robot.clickAndClick();
    }

    public static void choseCommand(){
        waitSimilarPicture(choseCommandStrStorage, choseCommand);
        sleep(timeAnimationButton);
        robot.move(choseCommand);
        robot.clickAndClick();
    }


}
