package monitorActions;

import imageTools.Image;
import imageTools.ImageTool;

import java.awt.*;

interface BaseForm {
    int timeCommonAnimation = 1000;
    int waiting = 2000;
    int percentOfDifference = 10;
    int percentOfBrokenPixels = 5;

    Roboharth robot = new Roboharth();

    default void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    default boolean isThatImageExist(String imgFromStorage, Rectangle img){
        return robot.getImage(img).getAsEncodedString().equals(imgFromStorage);
    }

    default boolean isSimilar(Image imgFromStorage, Rectangle img){
        byte[] findingImg = robot.getImage(img).byteData;
        byte[] storeImg = imgFromStorage.byteData;
        return ImageTool.differenceLessThan(percentOfDifference, percentOfBrokenPixels, findingImg, storeImg);
    }

    default boolean wait(Image imgFromStorage, Rectangle img){
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

    default boolean wait(Image imgFromStorage, Rectangle img, int times){
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

    default boolean waitSimilarPicture(String imgFromStorage, Rectangle img) {
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

    default void waitSimilarPicture(Image imgFromStorage, Rectangle img) {
        byte[] findingImg = robot.getImage(img).byteData;
        byte[] storeImg = imgFromStorage.byteData;

        while(!ImageTool.differenceLessThan(10, 5, findingImg, storeImg)){
            sleep(waiting);
            findingImg = robot.getImage(img).byteData;
        }
    }

    default void waitSimilarPicture(Image img1, Image img2, Rectangle find) {
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
