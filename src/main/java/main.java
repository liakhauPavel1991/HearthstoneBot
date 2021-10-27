import actions.Hero;
import actions.Opening;
import actions.Roboharth;
import actions.Step;
import pictureActions.Rectangles;
import points.Point;
import points.Points;
import scenaries.Scenaries;
import utils.ScreenUtil;
import utils.readers.FileReader;
import utils.readers.PropertyReader;

import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class main {
    public static Roboharth robot = new Roboharth();

    public static void main(String[] args) throws IOException, AWTException {
        Step.sleep(1000);
/*
        int i = 0;
        String name = "lvl_7 дерево мудрости";
        if(i == 0) {
            FileReader.writeInFile( "\n" + name + "\n" + ScreenUtil.getScrPieceAsString(Rectangles.imageEnemy));
            ScreenUtil.saveScrPiece(name , Rectangles.imageEnemy);
        } else {
            ScreenUtil.saveFullScreenshot("full_" + name);
        }
*/


        for (int i = 0; i < 1000; i++) {
            System.out.println(new Date() + " " + i);

      //  ScreenUtil.saveFullScreenshot("start " + i);
            Scenaries.startGame();

            Opening.opening(4, 2, 3, 4);
        ScreenUtil.saveFullScreenshot("after opening " + i);
            Step.turn(5000);

            Hero.firstAbility(500);
            Hero.firstAbilityInFirstEnemy(500);
            Hero.firstAbilityInSecondEnemy(1500);
            Step.turn(17000);

            Hero.firstAbility(500);
            Hero.thirdAbility(500);
            Hero.secondAbility(1500);
            Step.turn(14000);

    //    ScreenUtil.saveFullScreenshot("after fight " + i);

            Step.acceptWin(8500);
    //    ScreenUtil.saveFullScreenshot("after accepting " + i);
            Step.takePower(5000);
        ScreenUtil.saveFullScreenshot("after takinPower " + i);
            Step.backFromBattle(4000);


        }
    }
}




/*

//kern voljin anton
 for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            Scenaries.startGame();

            Opening.opening(4, 1, 3, 4);
            //Opening.opening(3, 1, 2, 3);

            Step.turn(5000);

            Hero.firstAbilityInFirstEnemy(500);
            Hero.firstAbilityInFirstEnemy(500);
            Hero.firstAbilityInSecondEnemy(1500);
            Step.turn(17000);

            Hero.thirdAbility(500);
            Hero.secondAbility(500);
            Hero.secondAbility(1500);
            Step.turn(14000);

            Step.acceptWin(8000);
            Step.takePower(5500);
            Step.backFromBattle(5000);


        }


/
        Point point970_650 = new Point(1450, 300);
        Dimension dimension100x150 = new Dimension(100, 150);
        ScreenUtil.saveScrPiece("afterWin2", point970_650, dimension100x150);
        String gettingStr = ScreenUtil.getScrPieceAsString(point970_650, dimension100x150);
   /     FileReader.writeInPictures("\n"+gettingStr);


        for(int i = 0; i < 100; i ++){
        ScreenUtil.saveFullScreenshot("Start" + i);
        FileReader.writeInFile("\nStart" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));

        Scenaries.startGame();
        ScreenUtil.saveFullScreenshot("AfterStart" + i);
        FileReader.writeInFile("\nAfterStart" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));

        Opening.opening(3, 1, 2, 3);
        ScreenUtil.saveFullScreenshot("AfterOpening" + i);
        FileReader.writeInFile("\nAfterOpening" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));


        Step.turn(5000);

        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInSecondEnemy(1500);
        Step.turn(17000);

        Hero.thirdAbility(500);
        Hero.secondAbility(500);
        Hero.secondAbility(1500);
        Step.turn(13000);

        ScreenUtil.saveFullScreenshot("AfterFight" + i);
        FileReader.writeInFile("\nAfterFight" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));

        Step.acceptWin(7500);
        ScreenUtil.saveFullScreenshot("AfterAcceptWin" + i);
        FileReader.writeInFile("\nAfterAcceptWin" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));

        Step.takePower(5000);
        ScreenUtil.saveFullScreenshot("AfterTakePower" + i);
        FileReader.writeInFile("\nAfterTakePower" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));

        Point point970_650 = new Point(1450, 300);
        Dimension dimension100x150 = new Dimension(100, 150);

        // Step.backFromBattle(5000);
        robot.move(Points.lookAtBand);
        robot.clickAndClick();
        ScreenUtil.saveFullScreenshot("clickOnBand" + i);
        FileReader.writeInFile("\nclickOnBand" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));

        Step.sleep(1200);
        robot.move(Points.backFromBattle);
        robot.clickAndClick();

        ScreenUtil.saveFullScreenshot("clickBack" + i);
        FileReader.writeInFile("\nclickBack" + i + "\n" + ScreenUtil.getScrPieceAsString(new Point(0,0), new Dimension(1920, 1080)));

        Step.sleep(1200);
        robot.move(Points.acceptBack);
        Step.sleep(150);
        robot.clickAndClick();
        Step.sleep(2000);
        robot.clickAndClick(); // взять награды
        Step.sleep(1000);
        robot.clickAndClick();
        Step.sleep(5000);
 */



