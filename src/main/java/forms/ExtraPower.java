package forms;

import utils.readers.PropertyReader;
import utils.readers.ScriptCreator;

import java.awt.*;
import java.io.IOException;

public class ExtraPower extends BaseForm{
    private final int extraLoadingTime = 5000;
    private final int timeMapLoading = 5000;

    private static final String heroIconStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "heroIcon");
    private static final String leftExtraPowerStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "leftExtraPower");
    private static final String centerExtraPowerStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "centerExtraPower");
    private static final String rightExtraPowerStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "rightExtraPower");
    private static final String takeBtnScr = PropertyReader.getProperty(PropertyReader.dataFilePath, "takeBtn");

    private static final Rectangle heroIcon = new Rectangle(400, 450, 50,50);
    private static final Rectangle leftExtraPower = new Rectangle(800, 350, 50,50);
    private static final Rectangle centerExtraPower = new Rectangle(1100, 350, 50,50);
    private static final Rectangle rightExtraPower = new Rectangle(1400, 350, 50,50);
    private static final Rectangle takeBtn = new Rectangle(1100, 840, 40, 40);


    public boolean isExtraPower(){
        if(isThatImageExist(takeBtnScr, takeBtn)){
            sleep(extraLoadingTime);
        }
        return isThatImageExist(takeBtnScr, takeBtn);
    }

    public void saveExtraPowerJpeg(int i) throws IOException, AWTException {
        ScriptCreator.saveJPEG("full" + i, new Rectangle(0, 0, 1920,1080));
        ScriptCreator.saveJpegExtraPower("Hero " + i, heroIcon);
        ScriptCreator.saveJpegExtraPower("leftExtraPower " + i, leftExtraPower);
        ScriptCreator.saveJpegExtraPower("centerExtraPower " + i, centerExtraPower);
        ScriptCreator.saveJpegExtraPower("rightExtraPower " + i, rightExtraPower);
    }

    public void takePower(){
        waitSimilarPicture(takeBtnScr, takeBtn);
        robot.clickAndClick();
        sleep(100);
        robot.move(takeBtn);
        robot.clickAndClick();
        sleep(timeMapLoading);
    }
}
