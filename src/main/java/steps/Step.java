package steps;

import forms.*;
import imageTools.ScreenUtil;

public class Step {

    public static void battleFieldPreparing(int heroCount, int first, int second, int third){
        BattleField.opening(heroCount, first, second, third);
        BattleField.turn();
        BattleField.prepareBattle();
    }

    public static void afterFight(){
        BattleField.acceptWin();
        ExtraPower.takePower();
    }

    public static void fight(){
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
        }
    }
}
