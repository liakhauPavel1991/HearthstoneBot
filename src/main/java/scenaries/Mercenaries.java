package scenaries;

import actions.Hero;
import actions.CommonAction;

public class Mercenaries {
    public static void MillhousVoljinKern2(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();

        Hero.firstAbility(500);
        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInSecondEnemy(1500);
        CommonAction.turn(17000);

        Hero.firstAbility(500);
        Hero.secondAbility(500);
        Hero.thirdAbility(1500);
        CommonAction.turn(13000);

        Scenaries.endGame();
    }

    public static void KernAntonVoljin(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();

        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInFirstEnemy(500);
        Hero.firstAbilityInSecondEnemy(1500);
        CommonAction.turn(17000);

        Hero.thirdAbility(500);
        Hero.secondAbility(500);
        Hero.secondAbility(1500);
        CommonAction.turn(13000);
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

        CommonAction.firstAbility(500);
        CommonAction.firstAbilityInFirstEnemy(500);
        CommonAction.firstAbilityInSecondEnemy(1500);
        CommonAction.turn(17000);

        CommonAction.firstAbility(500);
        CommonAction.secondAbility(500);
        CommonAction.thirdAbility(1500);
        CommonAction.turn(13500);

        Scenaries.endGame();
    }

    public static void MillhouseUtherJagga(){
        Scenaries.startGame();
        Scenaries.putHero_First_1_Second_3_Third_2();

        CommonAction.firstAbility(500);
        CommonAction.firstAbilityInSecondEnemy(500);
        CommonAction.firstAbilityInFirstEnemy(1500);
        CommonAction.turn(17000);

        CommonAction.firstAbility(500);
        CommonAction.thirdAbility(500);
        CommonAction.thirdAbility(1500);
        CommonAction.turn(13500);

        Scenaries.endGame();
    }
}
