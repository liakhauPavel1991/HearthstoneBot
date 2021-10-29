package forms;

import utils.readers.PropertyReader;

import java.awt.*;

public class PrizesForm extends BaseForm{
    private final int delay = 300;
    private final int pf = 5000;

    private final Rectangle onTheTop = new Rectangle(1000, 300, 20, 5);
    private final Rectangle inTheTopRightCorner = new Rectangle(1350, 450, 20, 5);
    private final Rectangle inTheLowerRightCorner = new Rectangle(1250, 850, 20, 5);
    private final Rectangle inTheLowerLeftCorner = new Rectangle(750, 850, 20, 5);
    private final Rectangle inTheTopLeftCorner = new Rectangle(650, 450, 20, 5);
    private final Rectangle doneBtn = new Rectangle(940, 540, 40, 40);
    private final Rectangle acceptCompletedBtn = new Rectangle(900, 860, 20, 20);

    private static final String doneBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "doneBtn");
    private static final String acceptCompletedBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "acceptCompletedBtn");

    private void clickPrizes(){
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

    public void getPrizes(){
        clickPrizes();
        sleep(700);
        if(!isSimilarImageExist(doneBtnStr, doneBtn)){
            clickPrizes();
        }
        robot.move(doneBtn);
        robot.click();
        sleep(4000);
        robot.move(acceptCompletedBtn);
        robot.click();
        sleep(2000);
    }


}
