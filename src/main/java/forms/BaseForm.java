package forms;

import actions.Roboharth;
import java.awt.*;

public class BaseForm {
    protected static int waiting = 2000;
    protected static Roboharth robot = new Roboharth();

    protected void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean isIt (String imgFromStorage, Rectangle img, int waitTimes){
        boolean isIt = robot.getImage(img).getAsEncodedString().equals(imgFromStorage);
        if(!isIt){
            sleep(waitTimes);
            isIt(imgFromStorage, img, waitTimes);
        }
        return isIt;
    }

    protected boolean isIt (String imgFromStorage, Rectangle img){
        return robot.getImage(img).getAsEncodedString().equals(imgFromStorage);
    }
}
