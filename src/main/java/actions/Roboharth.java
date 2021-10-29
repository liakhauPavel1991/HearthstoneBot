package actions;

import imageTools.Image;
import java.awt.*;
import java.awt.event.InputEvent;

public class Roboharth {
    public static Robot robot;

    public Roboharth() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public Image getImage(Rectangle rectangle){
        return new Image(robot.createScreenCapture(rectangle));
    }

    public void click(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        sleep(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        sleep(80);
    }

    public void rightClick(){
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        sleep(50);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        sleep(80);
    }

    public void clickAndClick(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        sleep(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        sleep(60);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        sleep(80);
    }

    public void press(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        sleep(80);
    }

    public void unpress(){
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        sleep(80);
    }

    public void move(Point point){
        robot.mouseMove(point.x, point.y);
        sleep(200);
    }

    public void move(Rectangle rectangle){
        robot.mouseMove(rectangle.x, rectangle.y);
        sleep(200);
    }

    public void move(int x, int y){
        robot.mouseMove(x, y);
        sleep(50);
    }

    public void wheelUp(int count){
        robot.mouseWheel(count);
    }

    private static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
