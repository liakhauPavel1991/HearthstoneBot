package actions;

import points.Points;

public class Hero {
    private static Roboharth robot = new Roboharth();

    public static void firstAbility(int millis){
        robot.move(Points.firstAbility);
        robot.click();
        robot.move(Points.firstEnemy);
        robot.rightClick();
        sleep(millis);
    }

    public static void secondAbility(int millis){
        robot.move(Points.secondAbility);
        robot.click();
        robot.move(Points.firstEnemy);
        robot.rightClick();
        sleep(millis);
    }

    public static void thirdAbility(int millis){
        robot.move(Points.thirdAbility);
        robot.click();
        robot.move(Points.firstEnemy);
        robot.rightClick();
        sleep(millis);
    }

    public static void firstAbilityInFirstEnemy(int millis){
        robot.move(Points.firstAbility);
        robot.click();
        robot.move(Points.firstEnemy);
        robot.click();
        robot.move(Points.firstEnemy);
        robot.rightClick();
        sleep(millis);
    }

    public static void firstAbilityInSecondEnemy(int millis){
        robot.move(Points.firstAbility);
        robot.click();
        robot.move(Points.secondEnemy);
        robot.click();
        robot.move(Points.firstEnemy);
        robot.rightClick();
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
