package forms;

import imageTools.Image;
import utils.readers.PropertyReader;
import java.awt.*;

public class ChoseBattle extends BaseForm{
    private final int choseCommandLoading = 3000;
    private static final Rectangle choseEnemyBand = new Rectangle(1480, 830, 20, 20);
    private static final String choseEnemyBandImg = PropertyReader.getProperty(PropertyReader.dataFilePath, "choseEnemyBand");
    private static final Image choseEnemyBandObj = new Image(choseEnemyBandImg, choseEnemyBand);

    public void choseBattle(){
        waitSimilarPicture(choseEnemyBandObj, choseEnemyBand);
        robot.move(choseEnemyBand);
        robot.clickAndClick();
        sleep(choseCommandLoading);
    }


}
