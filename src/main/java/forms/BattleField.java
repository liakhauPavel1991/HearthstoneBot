package forms;

import actions.CommonAction;
import imageTools.Image;
import utils.readers.PropertyReader;
import java.awt.*;

public class BattleField extends BaseForm {
    private static final int timeFieldAnimation = 3000;
    private static final int extraLoadingTime = 5000;
    private static final int timeFirstOnTable = 700;
    private static final int timeSecondOnTable = 700;
    private static final int timeThirdOnTable = 2000;
    private static final int timeTurn = 5100;
    private static final int timeLoadMapAfterBattle = 8500;

    //1 hero
    private static final Point onlyOneHero = new Point(970, 1000);
    //2 heroes
    private static final Point firstFrom2 = new Point(900,1000);
    private static final Point secondFrom2 = new Point(1050, 1000);
    //3 heroes
    private static final Point firstFrom3 = new Point(820, 1000);
    private static final Point secondFrom3 = new Point(970, 1000);
    private static final Point thirdFrom3 = new Point(1070, 1000);
    //4 heroes
    private static final Point firstFrom4 = new Point(750, 1000);
    private static final Point secondFrom4 = new Point(900, 1000);
    private static final Point thirdFrom4 = new Point(1050, 1000);
    private static final Point fourthFrom4 = new Point(1170, 1000);
    //5 heroes
    private static final Point firstFrom5 = new Point(750, 1000);
    private static final Point secondFrom5 = new Point(850, 1000);
    private static final Point thirdFrom5 = new Point(920, 1000);
    private static final Point fourthFrom5 = new Point(1050, 1000);
    private static final Point fifthFrom5 = new Point(1150, 1000);
    //6 heroes
    private static final Point firstFrom6 = new Point(720, 1000);
    private static final Point secondFrom6 = new Point(820, 1000);
    private static final Point thirdFrom6 = new Point(900, 1000);
    private static final Point fourthFrom6 = new Point(1000, 1000);
    private static final Point fifthFrom6 = new Point(1080, 1000);
    private static final Point sixthFrom6 = new Point(1200, 1000);
    //table heroes position
    private static final Point rightTablePosition = new Point(1150, 600);
    private static final Point leftTablePosition = new Point(750, 600);
    private static final Point turn = new Point(1560, 500);

    private static final Rectangle myNameLbl = new Rectangle(35, 930, 20, 5);
    private static final Rectangle winLbl = new Rectangle(900, 1020, 100, 15);
    private static final Rectangle firstAbility = new Rectangle(760, 460, 20, 20);

    private static final Image myNameLblStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "myNameLbl"), myNameLbl);
    private static final Image winLblStr = new Image(PropertyReader.getProperty(PropertyReader.dataFilePath, "winLbl"), winLbl);


    private static Image firstAbilityObj;


    public static void opening(int heroCount, int first, int second, int third){
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

    private static void heroOnTable(Point point, int millis){
        robot.move(point);
        CommonAction.sleep(150);
        robot.press();
        CommonAction.sleep(200);
        robot.move(rightTablePosition);
        CommonAction.sleep(100);
        robot.unpress();
        CommonAction.sleep(millis);
    }

    private static Point positions(int heroCount, int who){
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

    public static void turn(){
        robot.move(turn);
        robot.clickAndClick();
    }

    public static void acceptWin(){
        waitSimilarPicture(winLblStr, winLbl);
        robot.clickAndClick();
        sleep(500);
        robot.clickAndClick();
    }

    public static void prepareBattle(){
        sleep(timeTurn);
        firstAbilityObj = robot.getImage(firstAbility);
    }

    public static boolean doesReadyToFight(){
        return wait(firstAbilityObj, firstAbility, 1);
    }



}
