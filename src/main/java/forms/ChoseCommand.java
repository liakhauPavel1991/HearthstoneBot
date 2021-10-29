package forms;

import utils.readers.PropertyReader;
import java.awt.*;

public class ChoseCommand extends BaseForm{
    private int mapLoading = 3000;
    private static String choseCommandStrStorage = PropertyReader.getProperty(PropertyReader.dataFilePath, "choseCommand");
    private static final Rectangle choseCommand = new Rectangle(1440, 880, 20,20);

    public void choseCommand(){
        waitSimilarPicture(choseCommandStrStorage, choseCommand);
        robot.move(choseCommand);
        robot.clickAndClick();
        if(isThatImageExist(choseCommandStrStorage, choseCommand)){
            choseCommand();
        }
        sleep(mapLoading);
    }

}
