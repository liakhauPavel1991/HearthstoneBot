package forms;

import utils.readers.PropertyReader;

import java.awt.*;

public class BattleField extends BaseForm {
    private final int extraLoadingTime = 5000;
    public static final Rectangle loadedBattleField = new Rectangle(1600, 490, 10, 10);
    private static final String loadedBattleFieldStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "loadedBattleField");

    public boolean isBattleFieldLoaded(){
        if(isIt(loadedBattleFieldStr, loadedBattleField)){
            sleep(extraLoadingTime);
        }
        return isIt(loadedBattleFieldStr, loadedBattleField);
    }

}
