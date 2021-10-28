package scenaries;

import actions.CommonAction;

public class Scenaries {
    public static void startGame(){
        CommonAction.choseBattle(2000);
        CommonAction.choseBand(6500);
        CommonAction.startBattle(20000);
    }

    public static void putHero_First_1_Second_3_Third_2(){
        CommonAction.firstHeroOnTable(350);
        CommonAction.thirdHeroOnTable(350);
        CommonAction.secondHeroOnTable(3000);
        CommonAction.turn(5000);
    }

    public static void fight_First_1_Second_2_third_3(int millis){
        CommonAction.firstAbility(400);
        CommonAction.secondAbility(400);
        CommonAction.thirdAbility(1500);
        CommonAction.turn(millis);
    }

    public static void fight_First_1_Second_2_Third_2(int millis){
        CommonAction.firstAbility(500);
        CommonAction.secondAbility(500);
        CommonAction.secondAbility(1500);
        CommonAction.turn(millis);
    }

    public static void fight_First_1_Second_2_Third_1(int millis){
        CommonAction.firstAbility(500);
        CommonAction.secondAbility(500);
        CommonAction.firstAbilityInFirstEnemy(1500);
        CommonAction.turn(millis);
    }

    public static void endGame(){
        CommonAction.acceptWin(7500);
        CommonAction.takePower(4800);
        CommonAction.backFromBattle(5000);
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
