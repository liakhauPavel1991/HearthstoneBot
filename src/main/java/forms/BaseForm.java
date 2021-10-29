package forms;

import actions.Roboharth;
import imageTools.Image;
import imageTools.ImageTool;

import java.awt.*;

public class BaseForm {
    protected static int waiting = 2000;
    protected static Roboharth robot = new Roboharth();

    public void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean isThatImageExist(String imgFromStorage, Rectangle img){
        return robot.getImage(img).getAsEncodedString().equals(imgFromStorage);
    }

    protected boolean isSimilarImageExist(String imgFromStorage, Rectangle img){
        byte[] findingImg = robot.getImage(img).byteData;
        byte[] storeImg = new Image(Image.getImageFromString(imgFromStorage)).byteData;
        return ImageTool.differenceLessThan(10, 5, findingImg, storeImg);
    }



    protected boolean wait(String imgFromStorage, Rectangle img){
        String findingImg = robot.getImage(img).getAsEncodedString();
        boolean isEquals = findingImg.equals(imgFromStorage);
        for(int i = 0; i < 5 && !isEquals; i++){
            sleep(waiting);
            findingImg = robot.getImage(img).getAsEncodedString();
            isEquals = findingImg.equals(imgFromStorage);
            System.out.println("Warbning " + i);
            if(isEquals){
                System.out.println("Find not with first time");
                break;
            }
        }
        /*
        Image findingImg = robot.getImage(img);
        Image storeImg = new Image(Image.getImageFromString(imgFromStorage));
        boolean isEquals = findingImg.equals(storeImg);
        for(int i = 0; i < 5 && !isEquals; i++){
            sleep(waiting);
            findingImg = robot.getImage(img);
            isEquals = findingImg.equals(storeImg);
            if(isEquals){
                break;
            }
        }*/
        return isEquals;
    }

    protected boolean wait(Image imgFromStorage, Rectangle img){
        Image findingImg = robot.getImage(img);
        boolean isEquals = imgFromStorage.equals(findingImg);

        for(int i = 0; i < 5 && !isEquals; i++){
            sleep(waiting);
            findingImg = robot.getImage(img);
            isEquals = findingImg.equals(imgFromStorage);
            System.out.println("Warbning " + i);
            System.out.println("finding: " + findingImg);
            System.out.println("storage: " + imgFromStorage);
            if(isEquals){
                break;
            }
        }
        return isEquals;
        }

    protected boolean wait(Image imgFromStorage, Rectangle img, int times){
        Image findingImg = robot.getImage(img);
        boolean isEquals = imgFromStorage.equals(findingImg);

        for(int i = 0; i < times && !isEquals; i++){
            sleep(waiting);
            findingImg = robot.getImage(img);
            isEquals = findingImg.equals(imgFromStorage);
            System.out.println("Warbning: images are not equals" + i);
            if(isEquals){
                break;
            }
        }
        return isEquals;
    }

    protected boolean waitSimilarPicture(String imgFromStorage, Rectangle img) {
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
}
