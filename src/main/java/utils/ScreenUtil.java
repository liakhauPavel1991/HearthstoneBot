package utils;


import actions.Roboharth;
import aquality.selenium.browser.AqualityServices;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import points.Point;
import points.ScreenDimensions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;


public class ScreenUtil {

    public static void saveFullScreenshot(String fileName) throws AWTException, IOException {
        ImageIO.write(getFullScreen(), "jpeg", new File(fileName + ".jpeg"));
    }

    public static void saveScrPiece(String fileName, Point point) throws AWTException, IOException {
        BufferedImage piece = getFullScreen().getSubimage(point.x, point.y, ScreenDimensions.heroInMenu.width ,ScreenDimensions.heroInMenu.height);
        ImageIO.write(piece, "jpeg", new File(fileName + ".jpeg"));
    }

    public static void saveScrPiece(String fileName, Rectangle rectangle) throws AWTException, IOException {
        BufferedImage piece = getFullScreen().getSubimage(rectangle.x, rectangle.y, rectangle.width , rectangle.height);
        ImageIO.write(piece, "jpeg", new File(fileName + ".jpeg"));
    }

    public static void saveScrPiece(String fileName, Point point, Dimension dimension) throws AWTException, IOException {
        BufferedImage piece = getFullScreen().getSubimage(point.x, point.y, dimension.width ,dimension.height);
        ImageIO.write(piece, "jpeg", new File(fileName + ".jpeg"));
    }

    private static BufferedImage getFullScreen() throws AWTException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        return new Robot().createScreenCapture(screenRectangle);
    }

    public static String getScrPieceAsString(Point point, Dimension dimension) throws AWTException, IOException {
        BufferedImage piece = getFullScreen().getSubimage(point.x, point.y, dimension.width ,dimension.height);
        return Base64.getEncoder().encodeToString(imageToByteArray(piece));
    }

    public static String getScrPieceAsString(Rectangle rectangle) throws AWTException, IOException {
        BufferedImage piece = new Robot().createScreenCapture(rectangle);
        return Base64.getEncoder().encodeToString(imageToByteArray(piece));
    }

    public static byte[] getScrPieceAsByteArray(Rectangle rectangle) throws AWTException, IOException {
        BufferedImage piece = new Robot().createScreenCapture(rectangle);
        return imageToByteArray(piece);
    }


    private static byte[] imageToByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(byteArray);
        encoder.encode(image);
        return byteArray.toByteArray();
    }




    public static String captureToBase64() {

        Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenCapture = null;
        String base64Encoded = "";

        try {
            screenCapture = new Robot().createScreenCapture(screenSize);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenCapture, "jpg", baos);
            baos.flush();
            byte[] encodeBase64 = Base64.getEncoder().encode(baos.toByteArray());
            base64Encoded = new String(encodeBase64);
            baos.close();
        } catch (AWTException | IOException e) {
            e.getMessage();
        }

        return base64Encoded;
    }

}
