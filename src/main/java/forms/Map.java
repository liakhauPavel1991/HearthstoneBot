package forms;

import utils.readers.PropertyReader;

import java.awt.*;

public class Map extends BaseForm{
    private final int battleLoading = 20000;
    private static final String playBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "playBtn");
    private static final String lookCommandStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "lookCommand");
    private static final Rectangle playBtn = new Rectangle(1500, 830, 20,20);
    private static final Rectangle lookCommand = new Rectangle(700, 990, 20,20);

    public void startBattle(){
        isIt(playBtnStr, playBtn, waiting);
        robot.move(playBtn);
        robot.clickAndClick();
        if(isIt(playBtnStr, playBtn)){
            startBattle();
        }
        sleep(battleLoading);
    }


}
