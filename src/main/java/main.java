import forms.*;
import forms.Map;
import imageTools.ScreenUtil;
import steps.Step;
import utils.readers.ScriptCreator;

import java.awt.*;
import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException, AWTException, ClassNotFoundException {
        BattleField.sleep(1000);



         farm();

        //baseCycleScript();

    }

    private static void farm(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(new Date() + " --------------------------" + i);
            StartPreparing.choseBattle();
            StartPreparing.choseCommand();

            while(Map.fightToEnd > 0){
                Map.findBestEnemy();
                System.out.println("-----------------------------------Battle #" + Map.fightToEnd);
                Step.battleFieldPreparing(4, 1, 3, 4);
                Step.fight();
                Step.afterFight();
            }

            System.out.println("------------------------------ Boss Fight ");
            Map.startBattle();
            Step.battleFieldPreparing(4, 1, 3, 4);
            Step.fight();
            System.out.println("acceptWin");
            BattleField.acceptWin();
            System.out.println("getPrizes");
            PrizesForm.getPrizes();

        }
    }


    private static void takeScreen() throws IOException, AWTException {

        String fileName = "portalImage";
        Rectangle myNameLblStr = new Rectangle(1450, 280, 100, 100);
        ScriptCreator.create(fileName, myNameLblStr);
    }
/*
    private static void baseCycleScript() throws IOException, AWTException {

        for (int i = 0; i < 1000; i++) {
            System.out.println(new Date() + " " + i);

            StartPreparing.choseBattle();
            StartPreparing.choseCommand();
            Map.startBattle();

            for(int j = 0; j < Map.fightToEnd;){
                System.out.println("-----------------------------------Battle #####------------------------------------" + j);
                BattleField.opening(4, 1, 2, 4);
                BattleField.turn();
                BattleField.prepareBattle();
                fight();
                System.out.println("Accepting Win");
                BattleField.acceptWin();
                ExtraPower.takePower();
                j = Map.findBestEnemy(j);
            }
            System.out.println("Boss Fight ------------------------------");
            Map.startBattle();
            BattleField.opening(4, 1, 2, 4);
            BattleField.turn();
            BattleField.prepareBattle();
            System.out.println(BattleField.isReadyToFight());
            BattleField.sleep(5000);
            System.out.println("Fight");
            fight();
            System.out.println("Accepting Win");
            BattleField.acceptWin();

            System.out.println("getPrizes");

            PrizesForm.getPrizes();

        }
    }

    private static void fight(){
        while(BattleField.isReadyToFightWith10SecWaiting()){
            ScreenUtil.saveFullScreenshot("fight1");
            System.out.println("Battle turn ------------1 ");

            BattleHeroes.fight(1);
            BattleHeroes.fight(2);
            BattleHeroes.fight(1,2);
            BattleField.sleep(1000);
            BattleField.turn();

            BattleField.sleep(12000);

            if(BattleField.isReadyToFightWith10SecWaiting()){
                System.out.println("Battle turn --------------2" );
                ScreenUtil.saveFullScreenshot("fight2");
                BattleHeroes.fight(1);
                BattleHeroes.fight(2);
                BattleHeroes.fight(2);
                BattleField.sleep(1000);
                BattleField.turn();
                BattleField.sleep(10000);
            }
            ScreenUtil.saveFullScreenshot("end cycle");
            System.out.println("end cycle " + BattleField.isReadyToFight());
        }
    }
    private static void bossFight(){
        while(BattleField.isReadyToFight()){
            ScreenUtil.saveFullScreenshot("fight1");
            System.out.println("Battle turn ------------1 " + BattleField.isReadyToFight());

            BattleHeroes.fight(1);
            BattleHeroes.fight(2);
            BattleHeroes.fight(1,2);
            BattleField.sleep(1000);
            BattleField.turn();

            BattleField.sleep(22000);

            if(BattleField.isReadyToFight()){
                System.out.println("Battle turn --------------2" + BattleField.isReadyToFight());
                ScreenUtil.saveFullScreenshot("fight2");
                BattleHeroes.fight(1);
                BattleHeroes.fight(2);
                BattleHeroes.fight(2);
                BattleField.sleep(1000);
                BattleField.turn();
                BattleField.sleep(23000);
            }
            ScreenUtil.saveFullScreenshot("end cycle");
            System.out.println("end cycle " + BattleField.isReadyToFight());
        }
    }

    private static void takeScreen2() throws IOException, AWTException {

        String fileName = "repeatTakeBtn";
        Rectangle myNameLblStr = new Rectangle(1100, 840, 40, 40);
        ScriptCreator.create(fileName, myNameLblStr);
    }
*/



}






