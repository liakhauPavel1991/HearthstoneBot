package utils.readers;

import imageTools.Image;
import imageTools.ScreenUtil;
import pictureActions.Rectangles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScriptCreator {
    public static void create(String fileName, Rectangle rectangle) throws AWTException, IOException {
        BufferedImage bufferedImage = new Robot().createScreenCapture(rectangle);
        imageTools.Image img = new Image(bufferedImage);
        ScreenUtil.saveImage("src/main/resources/pictures/" + fileName, bufferedImage);
        String base64 = img.getAsEncodedString();
        System.out.println(base64);
        FileReader.writeInFile("src/main/resources/data.properties", fileName  + " = " + base64 + "\n");
    }

    public static void saveJPEG(String fileName, Rectangle rectangle) {
        try {
            ScreenUtil.saveImage("src/main/resources/pictures/extraPower/" + fileName, new Robot().createScreenCapture(rectangle));
            System.out.println(" fileName" + " .jpeg is created");
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveJpegExtraPower(String fileName, Rectangle rectangle) throws AWTException, IOException {
        BufferedImage bufferedImage = new Robot().createScreenCapture(rectangle);
        imageTools.Image img = new Image(bufferedImage);
        ScreenUtil.saveImage("src/main/resources/pictures/extraPower/" + fileName, bufferedImage);
        String base64 = img.getAsEncodedString();
        FileReader.writeInFile("src/main/resources/extraPower.properties", fileName + " = " + base64 + "\n");
    }


}

        /*String fileName = "choseEnemyBand";
        String fileName = "choseCommand";
        String fileName = "playBtn";
        String fileName = "lookCommand";
        String fileName = "loadedBattleField";

        */
