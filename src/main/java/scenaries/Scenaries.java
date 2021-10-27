package scenaries;

import actions.Step;

public class Scenaries {
    public static void startGame(){
        Step.choseBattle(2000);
        Step.choseBand(6500);
        Step.startBattle(20000);
    }

    public static void putHero_First_1_Second_3_Third_2(){
        Step.firstHeroOnTable(350);
        Step.thirdHeroOnTable(350);
        Step.secondHeroOnTable(3000);
        Step.turn(5000);
    }

    public static void fight_First_1_Second_2_third_3(int millis){
        Step.firstAbility(400);
        Step.secondAbility(400);
        Step.thirdAbility(1500);
        Step.turn(millis);
    }

    public static void fight_First_1_Second_2_Third_2(int millis){
        Step.firstAbility(500);
        Step.secondAbility(500);
        Step.secondAbility(1500);
        Step.turn(millis);
    }

    public static void fight_First_1_Second_2_Third_1(int millis){
        Step.firstAbility(500);
        Step.secondAbility(500);
        Step.firstAbilityInFirstEnemy(1500);
        Step.turn(millis);
    }

    public static void endGame(){
        Step.acceptWin(7500);
        Step.takePower(4800);
        Step.backFromBattle(5000);
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
