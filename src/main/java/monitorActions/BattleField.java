package monitorActions;

import imageTools.Image;
import utils.readers.Log;
import utils.readers.PropertyReader;
import java.awt.*;

interface BattleField extends BaseForm {
    int timeFieldAnimation = 3000;
    int timeFirstOnTable = 1200;
    int timeSecondOnTable = 1200;
    int timeThirdOnTable = 2200;
    int timeTurn = 7000;
    int timeLoadMapAfterBattle = 8500;

    //1 hero
    Point onlyOneHero = new Point(970, 1000);
    //2 heroes
    Point firstFrom2 = new Point(900,1000);
     Point secondFrom2 = new Point(1050, 1000);
    //3 heroes
    Point firstFrom3 = new Point(820, 1000);
    Point secondFrom3 = new Point(970, 1000);
    Point thirdFrom3 = new Point(1070, 1000);
    //4 heroes
    Point firstFrom4 = new Point(750, 1000);
    Point secondFrom4 = new Point(900, 1000);
    Point thirdFrom4 = new Point(1050, 1000);
    Point fourthFrom4 = new Point(1170, 1000);
    //5 heroes
    Point firstFrom5 = new Point(750, 1000);
    Point secondFrom5 = new Point(850, 1000);
    Point thirdFrom5 = new Point(920, 1000);
    Point fourthFrom5 = new Point(1050, 1000);
    Point fifthFrom5 = new Point(1150, 1000);
    //6 heroes
    Point firstFrom6 = new Point(720, 1000);
    Point secondFrom6 = new Point(820, 1000);
    Point thirdFrom6 = new Point(900, 1000);
    Point fourthFrom6 = new Point(1000, 1000);
    Point fifthFrom6 = new Point(1080, 1000);
    Point sixthFrom6 = new Point(1200, 1000);
    //table heroes position
    Point rightTablePosition = new Point(1150, 600);
    Point leftTablePosition = new Point(750, 600);
    Point turn = new Point(1560, 500);

    Rectangle myNameLbl = new Rectangle(35, 930, 20, 5);
    Rectangle winLbl = new Rectangle(900, 1020, 100, 15);
    Rectangle firstAbility = new Rectangle(760, 460, 20, 20);

    Image myNameLblStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "myNameLbl"), myNameLbl);
    Image winLblStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "winLbl"), winLbl);



    default void opening(int heroCount, int first, int second, int third){
        Log.info("Put heroes on the table");
        waitSimilarPicture(myNameLblStr, myNameLbl);
        sleep(timeFieldAnimation);

        heroOnTable(positions(heroCount, first), timeFirstOnTable);

        if(second > first){
            heroOnTable(positions(heroCount - 1, second - 1), timeSecondOnTable);
        } else {
            heroOnTable(positions(heroCount - 1, second ), timeSecondOnTable);
        }

        if(third > second && third > first){
            heroOnTable(positions(heroCount - 2, third - 2), timeThirdOnTable);
        }else if((third > second && third < first) || (third < second && third > first)){
            heroOnTable(positions(heroCount - 2, third - 1), timeThirdOnTable);
        }else {
            heroOnTable(positions(heroCount - 2, third ), timeThirdOnTable);
        }
    }

    default void heroOnTable(Point point, int millis){
        robot.move(point);
        sleep(150);
        robot.press();
        sleep(200);
        robot.move(rightTablePosition);
        sleep(100);
        robot.unpress();
        sleep(millis);
    }

    default Point positions(int heroCount, int who){
        Point position = null;
        switch (heroCount){
            case 1:
                position = onlyOneHero;
                break;
            case 2:
                switch (who) {
                    case 1:
                        position = firstFrom2;
                        break;
                    case 2:
                        position = secondFrom2;
                        break;
                }
                break;
            case 3:
                switch (who){
                    case 1:
                        position = firstFrom3;
                        break;
                    case 2:
                        position = secondFrom3;
                        break;
                    case 3:
                        position = thirdFrom3;
                        break;
                }
                break;
            case 4:
                switch (who){
                    case 1:
                        position = firstFrom4;
                        break;
                    case 2:
                        position = secondFrom4;
                        break;
                    case 3:
                        position = thirdFrom4;
                        break;
                    case 4:
                        position = fourthFrom4;
                        break;
                }
                break;
            case 5:
                switch (who){
                    case 1:
                        position = firstFrom5;
                        break;
                    case 2:
                        position = secondFrom5;
                        break;
                    case 3:
                        position = thirdFrom5;
                        break;
                    case 4:
                        position = fourthFrom5;
                        break;
                    case 5:
                        position = fifthFrom5;
                        break;
                }
                break;
            case 6:
                switch (who){
                    case 1:
                        position = firstFrom6;
                        break;
                    case 2:
                        position = secondFrom6;
                        break;
                    case 3:
                        position = thirdFrom6;
                        break;
                    case 4:
                        position = fourthFrom6;
                        break;
                    case 5:
                        position = fifthFrom6;
                        break;
                    case 6:
                        position = sixthFrom6;
                        break;
                }
                break;
        }
        return position;
    }

    default void turn(){
        robot.move(turn);
        robot.clickAndClick();
    }

    default void acceptWin(){
        robot.clickAndClick();
        sleep(500);
        robot.clickAndClick();
        sleep(1000);
        robot.clickAndClick();
    }
    /*
    default boolean isWin(){
        boolean isWin = isSimilar(winLblStr, winLbl);
        boolean isReadyToFight = isSimilar(firstAbilityObj, firstAbility);
        while(true){
            if(isWin){
                return true;
            } else if(isReadyToFight) {
                return false;
            }
            sleep(1000);
        }
    }*/

}
