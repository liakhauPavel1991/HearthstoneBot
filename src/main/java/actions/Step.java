package actions;

import points.*;
import utils.ScreenUtil;

import java.awt.*;
import java.io.IOException;

public class Step {
    private static actions.Roboharth robot = new actions.Roboharth();

    public static void choseBattle(int millis){
        robot.move(Points.choseBattle);
        robot.clickAndClick();
        sleep(millis);
    }

    public static void choseBand(int millis){
        robot.move(Points.choseBand);
        robot.clickAndClick();
        sleep(millis);
    }

    public static void exceptBands(int millis){
        robot.move(Points.exceptBands);
        sleep(millis);
    }

    public static void startBattle(int millis){
        robot.move(Points.startBattle);
        robot.clickAndClick();
        sleep(millis);
    }

    public static void firstHeroOnTable(int millis){
        robot.move(Points.firstHeroFrom3);
        robot.press();
        robot.move(Points.firstHeroTable);
        robot.unpress();
        sleep(millis);
    }

    public static void secondHeroOnTable(int millis){
        robot.move(Points.firstFrom2old);
        robot.press();
        robot.move(Points.secondHeroTable);
        robot.unpress();
        sleep(millis);
    }

    public static void thirdHeroOnTable(int millis){
        robot.move(Points.thirdHeroSecondTaken);
        robot.press();
        robot.move(Points.thirdHeroTable);
        robot.unpress();
        sleep(millis);
    }

    public static void turn(int millis){
        robot.move(Points.turn);
        robot.clickAndClick();
        sleep(millis);
    }


    public static void firstAbility(int millis){
        robot.move(Points.firstAbility);
        robot.click();
        sleep(millis);
    }

    public static void secondAbility(int millis){
        robot.move(Points.secondAbility);
        robot.click();
        sleep(millis);
    }

    public static void thirdAbility(int millis){
        robot.move(Points.thirdAbility);
        robot.click();
        sleep(millis);
    }

    public static void firstAbilityInFirstEnemy(int millis){
        robot.move(Points.firstAbility);
        robot.click();
        robot.move(Points.firstEnemy);
        robot.click();
        sleep(millis);
    }

    public static void firstAbilityInSecondEnemy(int millis){
        robot.move(Points.firstAbility);
        robot.click();
        robot.move(Points.secondEnemy);
        robot.click();
        sleep(millis);
    }

    public static void acceptWin(int millis){
        robot.clickAndClick();
        sleep(500);
        robot.clickAndClick();
        sleep(millis);
    }

    public static void takePower(int millis){
        robot.clickAndClick();
        sleep(100);
        robot.move(Points.takePower);
        robot.clickAndClick();
        sleep(millis);
    }

    public static void backFromBattle(int millis){
        robot.move(Points.lookAtBand);
        robot.clickAndClick();
        sleep(1200);
        robot.move(Points.backFromBattle);
        robot.clickAndClick();
        sleep(1100);
        robot.move(Points.acceptBack);
        sleep(300);
        robot.clickAndClick();
        sleep(2000);
        robot.clickAndClick(); // взять награды
        sleep(1000);
        robot.clickAndClick();
        sleep(millis);
    }

    public static void backFromBattleSaveScr(int millis, String scrName) throws IOException, AWTException {
        robot.move(Points.lookAtBand);
        robot.clickAndClick();
        sleep(1200);
        robot.move(Points.backFromBattle);
        robot.clickAndClick();
        sleep(1200);
        robot.move(Points.acceptBack);
        sleep(300);
        robot.clickAndClick();
        sleep(1000);
        robot.clickAndClick(); // взять награды
        sleep(1000);
        robot.clickAndClick();
        sleep(millis);
    }

    public static void choseSecondBattle(){

    }




    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
