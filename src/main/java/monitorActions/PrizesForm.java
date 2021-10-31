package monitorActions;

import imageTools.Image;
import utils.readers.PropertyReader;

import java.awt.*;
interface PrizesForm extends BaseForm{
    int delay = 300;

    Rectangle onTheTop = new Rectangle(1000, 300, 20, 5);
    Rectangle inTheTopRightCorner = new Rectangle(1350, 450, 20, 5);
    Rectangle inTheLowerRightCorner = new Rectangle(1250, 850, 20, 5);
    Rectangle inTheLowerLeftCorner = new Rectangle(750, 850, 20, 5);
    Rectangle inTheTopLeftCorner = new Rectangle(650, 450, 20, 5);
    Rectangle doneBtn = new Rectangle(940, 540, 40, 40);
    Rectangle acceptCompletedBtn = new Rectangle(900, 860, 20, 20);

    Image doneBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "doneBtn"), doneBtn);
    Image acceptCompletedBtnStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "acceptCompletedBtn"), acceptCompletedBtn);


    default void clickPrizes(){
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

    default void getPrizes(){
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
