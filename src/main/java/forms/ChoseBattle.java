package forms;

import utils.readers.PropertyReader;

import java.awt.*;

public class ChoseBattle extends BaseForm{
    private final int choseCommandLoading = 2000;
    private static final Rectangle choseEnemyBand = new Rectangle(1480, 830, 20, 20);
    private static final String choseEnemyBandImg = PropertyReader.getProperty(PropertyReader.dataFilePath, "choseEnemyBand");

    public void choseBattle(){
        isExist(choseEnemyBandImg, choseEnemyBand, waiting);
        robot.move(choseEnemyBand);
        robot.clickAndClick();
        if(isExist(choseEnemyBandImg, choseEnemyBand)){
            choseBattle();
        }
        sleep(choseCommandLoading);
    }

}
