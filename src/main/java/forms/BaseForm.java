package forms;

import actions.Roboharth;
import imageTools.Image;
import imageTools.ImageTool;

import java.awt.*;

public class BaseForm {
    protected static final int timeCommonAnimation = 1000;
    protected static int waiting = 2000;
    private static final int percentOfDifference = 10;
    private static final int percentOfBrokenPixels = 5;

    protected static Roboharth robot = new Roboharth();

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected static boolean isThatImageExist(String imgFromStorage, Rectangle img){
        return robot.getImage(img).getAsEncodedString().equals(imgFromStorage);
    }

    protected static boolean isSimilar(Image imgFromStorage, Rectangle img){
        byte[] findingImg = robot.getImage(img).byteData;
        byte[] storeImg = imgFromStorage.byteData;
        return ImageTool.differenceLessThan(percentOfDifference, percentOfBrokenPixels, findingImg, storeImg);
    }

    protected static boolean wait(Image imgFromStorage, Rectangle img){
        Image findingImg = robot.getImage(img);
        boolean isEquals = imgFromStorage.equals(findingImg);

        for(int i = 0; i < 5 && !isEquals; i++){
            sleep(waiting);
            findingImg = robot.getImage(img);
            isEquals = findingImg.equals(imgFromStorage);
            if(isEquals){
                break;
            }
        }
        return isEquals;
        }

    protected static boolean wait(Image imgFromStorage, Rectangle img, int times){
        Image findingImg = robot.getImage(img);
        boolean isEquals = imgFromStorage.equals(findingImg);

        for(int i = 0; i < times && !isEquals; i++){
            sleep(waiting);
            findingImg = robot.getImage(img);
            isEquals = findingImg.equals(imgFromStorage);
            if(isEquals){
                break;
            }
        }
        return isEquals;
    }

    protected static boolean waitSimilarPicture(String imgFromStorage, Rectangle img) {
        byte[] findingImg = robot.getImage(img).byteData;
        byte[] storeImg = new Image(Image.getImageFromString(imgFromStorage)).byteData;
        boolean isSimilar = ImageTool.differenceLessThan(10, 5, findingImg, storeImg);

        for (int i = 0; i < 5 && !isSimilar; i++) {
            sleep(waiting);
            findingImg = robot.getImage(img).byteData;
            isSimilar = ImageTool.differenceLessThan(10, 5, findingImg, storeImg);
            if (isSimilar) {
                break;
            }
        }
        return isSimilar;
    }

    protected static void waitSimilarPicture(Image imgFromStorage, Rectangle img) {
        byte[] findingImg = robot.getImage(img).byteData;
        byte[] storeImg = imgFromStorage.byteData;

        while(!ImageTool.differenceLessThan(10, 5, findingImg, storeImg)){
            sleep(waiting);
            findingImg = robot.getImage(img).byteData;
        }
    }

    protected static void waitSimilarPicture(Image img1, Image img2, Rectangle find) {
        byte[] findingImg = robot.getImage(find).byteData;
        byte[] storeImg1 = img1.byteData;
        byte[] storeImg2 = img2.byteData;

        while(!(ImageTool.differenceLessThan(10, 5, findingImg, storeImg1) ||
                ImageTool.differenceLessThan(10, 5, findingImg, storeImg2))){
            sleep(waiting);
            findingImg = robot.getImage(find).byteData;
        }
    }


}
