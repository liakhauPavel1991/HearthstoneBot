package monitorActions;

import imageTools.Image;
import imageTools.ScreenUtil;
import utils.readers.Log;

import java.awt.*;

public class Manager implements BattleField, BattleHeroes, ExtraPower, GettingTask, Map, Menu, PrizesForm, StartPreparing{
    public int fightToEnd;
    public boolean continueCycle = true;

    private Image firstAbilityObj;
    private Rectangle firstAbility = new Rectangle(760, 460, 20, 20);

    public void prepareNewCycle(int countEnemyes){
        continueCycle = true;
        fightToEnd = countEnemyes;
    }

    public void prepareBattle(){
        Log.info("Save a picture of a prepared hero");
        sleep(timeTurn);
        firstAbilityObj = robot.getImage(firstAbility);
    }

    public int findBestEnemy(){
        Log.info("Find Best Enemy. Remained fights: " + fightToEnd);
        waitMapLoading();
        if( hasChose()){
            Log.info("I have a chose");
            instructionWhatToDo(findBestOption());
        } else {
            Log.info("I have not a chose");
            instructionWhatToDo(mapEnemyPriority());
        }
        return fightToEnd;
    }

    public void instructionWhatToDo(EnemyPriority whatToDo){
        fightToEnd--;
        switch (whatToDo){
            case TASKER: {
                moveToNextEnemy();
                getTask();
                sleep(4000);
                findBestEnemy();
                break;
            }
            case ENEMY: {
                break;
            }
            case PORTAL: {
                fightToEnd = 0;
                moveToNextEnemy();
                break;
            }
            case BOMB: {
                continueCycle = false;
                backFromBattle();
            }
            case RESURRECTION:
            case EXTRA_POWER:
            case DIVERSION: {
                moveToNextEnemy();
                findBestEnemy();
                break;
            }
        }
    }

    public void fight(){
        while(isReadyToFightWith10SecWaiting()){
            Log.info("Battle turn ------------1 ");
            heroShot(1);
            heroShot(2);
            heroShot(1,2);
            sleep(1000);
            turn();
            sleep(12000);

            if(isReadyToFightWith10SecWaiting()){
                Log.info("Battle turn --------------2" );
                heroShot(1);
                heroShot(2);
                heroShot(2);
                sleep(1000);
                turn();
                sleep(10000);
            }
        }
    }

    private boolean isReadyToFightWith10SecWaiting(){
        for(int i = 0; i < 10; i++){
            if(!isSimilar(firstAbilityObj, firstAbility)){
                sleep(1000);
            }
        }
        return isSimilar(firstAbilityObj, firstAbility);
    }

}
