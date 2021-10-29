package forms;

import java.awt.*;

public class BattleHeroes extends BaseForm {
    private static final int timeAbilityAnimation = 500;

    private static final Point firstAbility = new Point(760, 460);
    private static final Point firstEnemy = new Point(780, 300);
    private static final Point secondAbility = new Point(950, 500);
    private static final Point secondEnemy = new Point(1000, 300);
    private static final Point thirdAbility = new Point(1150, 500);

    public static void fight(int ability){
        switch (ability){
            case 1: {
                firstAbility();
                break;
            }
            case 2: {
                secondAbility();
                break;
            }
            case 3: {
                thirdAbility();
                break;
            }
        }
    }

    public static void fight(int ability, int enemy){
        switch (ability){
            case 1: {
                firstAbility();
                clickOn(enemy);
                break;
            }
            case 2: {
                secondAbility();
                clickOn(enemy);
                break;
            }
            case 3: {
                thirdAbility();
                clickOn(enemy);
                break;
            }
        }
    }

    private static void clickOn(int enemy){
        switch (enemy){
            case 1:{
                onFirstEnemy();
                break;
            }
            case 2:{
                onSecondEnemy();
                break;
            }
        }
    }


    private static void firstAbility(){
        robot.move(firstAbility);
        robot.click();
        sleep(timeAbilityAnimation);
    }

    private static void secondAbility(){
        robot.move(secondAbility);
        robot.click();
        sleep(timeAbilityAnimation);
    }

    private static void thirdAbility(){
        robot.move(thirdAbility);
        robot.click();
        sleep(timeAbilityAnimation);
    }

    private static void onFirstEnemy(){
        robot.move(firstEnemy);
        robot.click();
        robot.move(firstEnemy);
        robot.rightClick();
        sleep(timeAbilityAnimation);
    }

    private static void onSecondEnemy(){
        robot.move(secondEnemy);
        robot.click();
        robot.move(firstEnemy);
        robot.rightClick();
        sleep(timeAbilityAnimation);
    }
}
