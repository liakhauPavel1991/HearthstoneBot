package monitorActions;

import imageTools.Image;
import utils.readers.Log;
import utils.readers.PropertyReader;
import utils.readers.ScriptCreator;

import java.awt.*;
import java.io.IOException;

interface ExtraPower extends BaseForm{
    int extraLoadingTime = 5000;
    int timeMapLoading = 5000;

    Rectangle heroIcon = new Rectangle(400, 450, 50,50);
    Rectangle leftExtraPower = new Rectangle(800, 350, 50,50);
    Rectangle centerExtraPower = new Rectangle(1100, 350, 50,50);
    Rectangle rightExtraPower = new Rectangle(1400, 350, 50,50);
    Rectangle takeBtn = new Rectangle(1100, 840, 40, 40);

  //  private static final Image heroIconStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "heroIcon"), heroIcon);
  //  private static final Image leftExtraPowerStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "leftExtraPower"),leftExtraPower);
  //  private static final Image centerExtraPowerStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "centerExtraPower"), centerExtraPower);
  //  private static final Image rightExtraPowerStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "rightExtraPower"), rightExtraPower);
    Image takeBtnScr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "takeBtn"), takeBtn);
    Image repeatTakeBtnScr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "repeatTakeBtn"), takeBtn);

    default  void saveExtraPowerJpeg(int i) throws IOException, AWTException {
        ScriptCreator.saveJPEG("full" + i, new Rectangle(0, 0, 1920,1080));
        ScriptCreator.saveJpegExtraPower("Hero " + i, heroIcon);
        ScriptCreator.saveJpegExtraPower("leftExtraPower " + i, leftExtraPower);
        ScriptCreator.saveJpegExtraPower("centerExtraPower " + i, centerExtraPower);
        ScriptCreator.saveJpegExtraPower("rightExtraPower " + i, rightExtraPower);
    }

    default  void takePower(){
        Log.info("Take Power");
        waitSimilarPicture(takeBtnScr, repeatTakeBtnScr , takeBtn);
        robot.clickAndClick();
        sleep(100);
        robot.move(takeBtn);
        robot.clickAndClick();
    }

}
