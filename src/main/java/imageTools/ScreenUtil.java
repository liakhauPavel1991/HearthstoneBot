package imageTools;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;


public class ScreenUtil {

    public static void saveFullScreenshot(String fileName) {
        try {
            ImageIO.write(getFullScreen(), "jpeg", new File(fileName + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void saveScrPiece(String fileName, Rectangle rectangle) {
        BufferedImage piece = null;
        try {
            piece = getFullScreen().getSubimage(rectangle.x, rectangle.y, rectangle.width , rectangle.height);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(piece, "jpeg", new File(fileName + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveScrPiece(String fileName, Point point, Dimension dimension) throws AWTException, IOException {
        BufferedImage piece = getFullScreen().getSubimage(point.x, point.y, dimension.width ,dimension.height);
        ImageIO.write(piece, "jpeg", new File(fileName + ".jpeg"));
    }

    public static void saveImage(String fileName, BufferedImage bufferedImage) throws AWTException, IOException {
        ImageIO.write(bufferedImage, "jpeg", new File(fileName + ".jpeg"));
    }

    private static BufferedImage getFullScreen() throws AWTException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        return new Robot().createScreenCapture(screenRectangle);
    }



    private static ArrayList imageAsIntArr(BufferedImage image){
        ArrayList arrayList = new ArrayList();
        for (int height = 0; height < image.getHeight(); height++){
            for(int width = 0; width < image.getWidth(); width++){
                arrayList.add(image.getRGB(width, height));
            }
        }
        return arrayList;
    }


}
