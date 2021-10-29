package actions;

import java.awt.*;
import java.io.IOException;

public class CommonAction {
    private static actions.Roboharth robot = new actions.Roboharth();

    public static void acceptWin(int millis){
        robot.clickAndClick();
        sleep(500);
        robot.clickAndClick();
        sleep(millis);
    }


    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
