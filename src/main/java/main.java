
import actions.Roboharth;
import actions.CommonAction;
import forms.*;
import forms.Map;
import forms.Menu;
import imageTools.ScreenUtil;
import utils.readers.PropertyReader;
import utils.readers.ScriptCreator;

import java.awt.*;
import java.io.*;
import java.util.*;

public class main {
    public static Roboharth robot = new Roboharth();

    public static void main(String[] args) throws IOException, AWTException, ClassNotFoundException {
        CommonAction.sleep(1000);


        baseCycleScript();


        //takeScreen();

    }

    private static void takeScreen() throws IOException, AWTException {
        System.out.println("Screen");

        String fileName = "acceptCompletedBtn";
        Rectangle myNameLblStr = new Rectangle(900, 860, 20, 20);
        ScriptCreator.create(fileName, myNameLblStr);
    }

    private static void baseCycleScript() throws IOException, AWTException {
        ChoseBattle choseBattle = new ChoseBattle();
        ChoseCommand choseCommand = new ChoseCommand();
        Map map = new Map();
        BattleField battleField = new BattleField();
        Menu menu = new Menu();
        BattleHeroes battleHeroes = new BattleHeroes();
        ExtraPower extraPower = new ExtraPower();
        PrizesForm prizesForm = new PrizesForm();

        for (int i = 0; i < 1000; i++) {
            System.out.println(new Date() + " " + i);
            choseBattle.choseBattle();
            choseCommand.choseCommand();
            map.startBattle();

            for(int j = 0; j < 6; j++){
                System.out.println("-----------------------------------Battle #####------------------------------------" + j);
                ScreenUtil.saveFullScreenshot("debagPicture/Battle" + j);
                battleField.opening(3, 1, 2, 4);
                battleField.turn();
                battleField.prepareBattle();
                while(battleField.doesReadyToFight()){
                    System.out.println("Battle turn ----------------------1");
                    ScreenUtil.saveFullScreenshot("debagPicture/fight" + j);
                    battleHeroes.fight(1);
                    battleHeroes.fight(2);
                    battleHeroes.fight(1,2);
                    battleField.sleep(1000);
                    CommonAction.turn(17000);
                    if(battleField.doesReadyToFight()){
                        System.out.println("Battle turn ----------------------2");
                        ScreenUtil.saveFullScreenshot("debagPicture/fight" + j);
                        battleHeroes.fight(1);
                        battleHeroes.fight(2);
                        battleHeroes.fight(2);
                        battleField.sleep(1000);
                        CommonAction.turn(14000);
                    }
                }
                System.out.println("Accepting Win");
                ScreenUtil.saveFullScreenshot("debagPicture/Win" + j);
                battleField.acceptWin();
                //extraPower.saveExtraPowerJpeg(i);
                System.out.println("extraPower.takePower();");
                ScreenUtil.saveFullScreenshot("debagPicture/takePower" + j);
                extraPower.takePower();
                System.out.println("map.findNextEnemy();");
                ScreenUtil.saveFullScreenshot("debagPicture/findNextEnemy" + j);
                map.findNextEnemy();
            }
            battleField.sleep(1000);
            System.out.println("getPrizes");
            ScreenUtil.saveFullScreenshot("getPrizes");
            prizesForm.getPrizes();

        }
    }

    private static void baseScriptOne() throws IOException, AWTException {
        ChoseBattle choseBattle = new ChoseBattle();
        ChoseCommand choseCommand = new ChoseCommand();
        Map map = new Map();
        BattleField battleField = new BattleField();
        Menu menu = new Menu();
        BattleHeroes battleHeroes = new BattleHeroes();
        ExtraPower extraPower = new ExtraPower();

        System.out.println("choseBattle");
            choseBattle.choseBattle();
        System.out.println("choseCommand");
            choseCommand.choseCommand();
        System.out.println("map.startBattle()");
            map.startBattle();
        System.out.println("opening");
            battleField.opening(3, 1, 2, 4);
        System.out.println("turn");
            battleField.turn();

            while(!battleField.isItWin()){
                System.out.println("first battle");
                battleHeroes.fight(1);
                battleHeroes.fight(2);
                battleHeroes.fight(1,2);
                battleField.sleep(1000);
                CommonAction.turn(17000);
                if(!battleField.isItWin()){
                    battleHeroes.fight(1);
                    battleHeroes.fight(2);
                    battleHeroes.fight(2);
                    battleField.sleep(1000);
                    CommonAction.turn(14000);
                }
            }

            battleField.acceptWin();
            extraPower.takePower();


    }

}






