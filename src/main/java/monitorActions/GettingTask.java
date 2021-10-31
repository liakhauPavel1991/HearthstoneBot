package monitorActions;

import utils.readers.PropertyReader;

import java.awt.*;

interface GettingTask extends BaseForm{
    String acceptTaskButtonStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "acceptTaskButton");

    Rectangle thirdHeroTaskIcon = new Rectangle(1200, 400, 20,20);
    Rectangle acceptTaskButton = new Rectangle(880, 720, 40,40);

    default  void getTask(){
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
