package monitorActions;

import java.awt.*;

interface BattleHeroes extends BaseForm {
    int timeAbilityAnimation = 500;

    Point firstAbility = new Point(760, 460);
    Point firstEnemy = new Point(780, 300);
    Point secondAbility = new Point(950, 500);
    Point secondEnemy = new Point(1000, 300);
    Point thirdAbility = new Point(1150, 500);


    default void heroShot(int ability){
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

    default void heroShot(int ability, int enemy){
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

    default void clickOn(int enemy){
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


    default void firstAbility(){
        robot.move(firstAbility);
        robot.click();
        sleep(timeAbilityAnimation);
    }

    default void secondAbility(){
        robot.move(secondAbility);
        robot.click();
        sleep(timeAbilityAnimation);
    }

    default void thirdAbility(){
        robot.move(thirdAbility);
        robot.click();
        sleep(timeAbilityAnimation);
    }

    default void onFirstEnemy(){
        robot.move(firstEnemy);
        robot.click();
        robot.move(firstEnemy);
        robot.rightClick();
        sleep(timeAbilityAnimation);
    }

    default void onSecondEnemy(){
        robot.move(secondEnemy);
        robot.click();
        robot.move(firstEnemy);
        robot.rightClick();
        sleep(timeAbilityAnimation);
    }
}
