package scenaries;

import actions.Hero;
import actions.Step;

public class Mercenaries {
    public static void MillhousVoljinKern2(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();

        Hero.firstAbility(500);
        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInSecondEnemy(1500);
        Step.turn(17000);

        Hero.firstAbility(500);
        Hero.secondAbility(500);
        Hero.thirdAbility(1500);
        Step.turn(13000);

        Scenaries.endGame();
    }

    public static void KernAntonVoljin(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();

        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInSecondEnemy(1500);
        Step.turn(17000);

        Hero.thirdAbility(500);
        Hero.secondAbility(500);
        Hero.secondAbility(1500);
        Step.turn(13000);
        Scenaries.endGame();
    }


    public static void MillhousTirandaVoljin(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();
        Scenaries.fight_First_1_Second_2_Third_1(17000);
        Scenaries.fight_First_1_Second_2_Third_2(13000);
        Scenaries.endGame();
    }

    public static void MillhousVoljinKern(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();
        Scenaries.fight_First_1_Second_2_Third_1(17000);
        Scenaries.fight_First_1_Second_2_third_3(13500);
        Scenaries.endGame();
    }

    public static void MillhouseVoljinJagga(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();

        Step.firstAbility(500);
        Step.firstAbilityInFirstEnemy(500);
        Step.firstAbilityInSecondEnemy(1500);
        Step.turn(17000);

        Step.firstAbility(500);
        Step.secondAbility(500);
        Step.thirdAbility(1500);
        Step.turn(13500);

        Scenaries.endGame();
    }

    public static void MillhouseUtherJagga(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();

        Step.firstAbility(500);
        Step.firstAbilityInSecondEnemy(500);
        Step.firstAbilityInFirstEnemy(1500);
        Step.turn(17000);

        Step.firstAbility(500);
        Step.thirdAbility(500);
        Step.thirdAbility(1500);
        Step.turn(13500);

        Scenaries.endGame();
    }
}
