
import actions.Roboharth;
import actions.CommonAction;
import forms.*;
import forms.Map;
import imageTools.ScreenUtil;
import utils.readers.ScriptCreator;

import java.awt.*;
import java.io.*;
import java.util.*;

public class main {
    public static Roboharth robot = new Roboharth();

    public static void main(String[] args) throws IOException, AWTException, ClassNotFoundException {
        CommonAction.sleep(1000);

        baseCycleScript();

    }

    private static void takeScreen() throws IOException, AWTException {
        System.out.println("Screen");

        String fileName = "acceptCompletedBtn";
        Rectangle myNameLblStr = new Rectangle(900, 860, 20, 20);
        ScriptCreator.create(fileName, myNameLblStr);
    }

    private static void baseCycleScript() throws IOException, AWTException {

        for (int i = 0; i < 1000; i++) {
            System.out.println(new Date() + " " + i);

            StartPreparing.choseBattle();
            StartPreparing.choseCommand();
            Map.startBattle();

            for(int j = 0; j < 6;){
                System.out.println("-----------------------------------Battle #####------------------------------------" + j);
                BattleField.opening(3, 1, 2, 4);
                BattleField.turn();
                BattleField.prepareBattle();

                while(BattleField.doesReadyToFight()){
                    System.out.println("Battle turn ----------------------1");

                    BattleHeroes.fight(1);
                    BattleHeroes.fight(2);
                    BattleHeroes.fight(1,2);
                    BattleField.sleep();
                    BattleField.turn();
                    if(BattleField.doesReadyToFight()){
                        System.out.println("Battle turn ----------------------2");

                        BattleHeroes.fight(1);
                        BattleHeroes.fight(2);
                        BattleHeroes.fight(2);
                        BattleField.sleep();
                        BattleField.turn();
                    }
                }
                System.out.println("Accepting Win");
                BattleField.acceptWin();
                ExtraPower.takePower();
                System.out.println("map.findNextEnemy();");
                j = Map.findBestEnemy(j);
                System.out.println(j + " turn---- END");
            }
            System.out.println("Boss Fight ------------------------------");
            Map.startBattle();
            BattleField.opening(3, 1, 2, 4);
            BattleField.turn();
            BattleField.prepareBattle();
            System.out.println("Fight");
            while(BattleField.doesReadyToFight()){
                System.out.println("Battle turn ------------1");

                BattleHeroes.fight(1);
                BattleHeroes.fight(2);
                BattleHeroes.fight(1,2);
                BattleField.sleep(1000);
                BattleField.turn();
                if(BattleField.doesReadyToFight()){
                    System.out.println("Battle turn --------------2");

                    BattleHeroes.fight(1);
                    BattleHeroes.fight(2);
                    BattleHeroes.fight(2);
                    BattleField.sleep(1000);
                    BattleField.turn();
                }
            }
            System.out.println("Accepting Win");
            BattleField.acceptWin();

            BattleField.sleep(1000);

            System.out.println("getPrizes");
            ScreenUtil.saveFullScreenshot("getPrizes");
            PrizesForm.getPrizes();

        }
    }




}






