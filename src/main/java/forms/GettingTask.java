package forms;

import utils.readers.PropertyReader;

import java.awt.*;

public class GettingTask extends BaseForm{
    private static final String acceptTaskButtonStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "acceptTaskButton");

    private static final Rectangle thirdHeroTaskIcon = new Rectangle(1200, 400, 20,20);
    private static final Rectangle acceptTaskButton = new Rectangle(880, 720, 40,40);

    public static void getTask(){
        sleep(2000);
        robot.move(thirdHeroTaskIcon);
        robot.click();
        sleep(300);
        robot.move(acceptTaskButton);
        robot.click();
        sleep(500);
        robot.click();
        sleep(1000);
    }


}
