package forms;

import imageTools.Image;
import utils.readers.PropertyReader;

import java.awt.*;

public class PrizesForm extends BaseForm{
    private static final int delay = 300;

    private static final Rectangle onTheTop = new Rectangle(1000, 300, 20, 5);
    private static final Rectangle inTheTopRightCorner = new Rectangle(1350, 450, 20, 5);
    private static final Rectangle inTheLowerRightCorner = new Rectangle(1250, 850, 20, 5);
    private static final Rectangle inTheLowerLeftCorner = new Rectangle(750, 850, 20, 5);
    private static final Rectangle inTheTopLeftCorner = new Rectangle(650, 450, 20, 5);
    private static final Rectangle doneBtn = new Rectangle(940, 540, 40, 40);
    private static final Rectangle acceptCompletedBtn = new Rectangle(900, 860, 20, 20);

    private static final Image doneBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "doneBtn"), doneBtn);
    private static final Image acceptCompletedBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "acceptCompletedBtn"), acceptCompletedBtn);


    private static void clickPrizes(){
        robot.move(onTheTop);
        robot.click();
        sleep(delay);
        robot.move(inTheTopRightCorner);
        robot.click();
        sleep(delay);
        robot.move(inTheLowerRightCorner);
        robot.click();
        sleep(delay);
        robot.move(inTheLowerLeftCorner);
        robot.click();
        sleep(delay);
        robot.move(inTheTopLeftCorner);
        robot.click();
        sleep(delay);
    }

    public static void getPrizes(){
        sleep(17000);
        clickPrizes();
        //waitSimilarPicture(doneBtnStr, doneBtn);
        sleep(delay);
        robot.move(doneBtn);
        robot.click();
        sleep(5000);
        robot.move(acceptCompletedBtn);
        robot.click();
        sleep(2000);
    }


}
