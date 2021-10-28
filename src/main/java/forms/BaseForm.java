package forms;

import actions.Roboharth;
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

    protected boolean isExist(String imgFromStorage, Rectangle img, int waitTimes){
        boolean isIt = robot.getImage(img).getAsEncodedString().equals(imgFromStorage);
        if(!isIt){
            sleep(waitTimes);
            isExist(imgFromStorage, img, waitTimes);
        }
        return isIt;
    }

    protected boolean isExist(String imgFromStorage, Rectangle img){
        return robot.getImage(img).getAsEncodedString().equals(imgFromStorage);
    }
}
