package forms;

import utils.readers.PropertyReader;
import java.awt.*;

public class ChoseCommand extends BaseForm{
    private int mapLoading = 2000;
    private static String choseCommandStrStorage = PropertyReader.getProperty(PropertyReader.dataFilePath, "choseCommand");
    private static final Rectangle choseCommand = new Rectangle(1440, 880, 20,20);

    public void choseCommand(){
        isIt(choseCommandStrStorage, choseCommand, waiting);
        robot.move(choseCommand);
        robot.clickAndClick();
        if(isIt(choseCommandStrStorage, choseCommand)){
            choseCommand();
        }
        sleep(mapLoading);
    }

}
