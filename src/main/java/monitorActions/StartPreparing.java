package monitorActions;

import imageTools.Image;
import utils.readers.Log;
import utils.readers.PropertyReader;
import java.awt.*;

public interface StartPreparing extends BaseForm{
    int timeAnimationButton = 1000;
    Rectangle choseEnemyBand = new Rectangle(1480, 830, 20, 20);
    Image choseEnemyBandObj = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "choseEnemyBand"), choseEnemyBand);

    Rectangle choseCommand = new Rectangle(1440, 880, 20,20);
    Image choseCommandStrStorage = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "choseCommand"), choseCommand);

    default void choseBattle(){
        Log.info("Chose battle");
        waitSimilarPicture(choseEnemyBandObj, choseEnemyBand);
        sleep(timeAnimationButton);
        robot.move(choseEnemyBand);
        robot.clickAndClick();
    }

    default void choseCommand(){
        Log.info("Chose command");
        waitSimilarPicture(choseCommandStrStorage, choseCommand);
        sleep(timeAnimationButton);
        robot.move(choseCommand);
        robot.clickAndClick();
    }


}
