package actions;

import points.Points;

import java.awt.*;


public class Opening {/*
    private static actions.Roboharth robot = new actions.Roboharth();

    public static void opening(int heroCount, int first, int second, int third){
        heroOnTable(positions(heroCount, first), 1100);

        if(second > first){
            heroOnTable(positions(heroCount - 1, second - 1), 700);
        } else {
            heroOnTable(positions(heroCount - 1, second ), 700);
        }

        if(third > second && third > first){
            heroOnTable(positions(heroCount - 2, third - 2), 2000);
        }else if((third > second && third < first) || (third < second && third > first)){
            heroOnTable(positions(heroCount - 2, third - 1), 2000);
        }else {
            heroOnTable(positions(heroCount - 2, third ), 2000);
        }
    }

    private static void heroOnTable(Point point, int millis){
        robot.move(point);
        CommonAction.sleep(150);
        robot.press();
        CommonAction.sleep(300);
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
                        position = Points.firstFrom3;
                        break;
                    case 2:
                        position = Points.secondFrom3;
                        break;
                    case 3:
                        position = Points.thirdFrom3;
                        break;
                }
                break;
            case 4:
                switch (who){
                    case 1:
                        position = Points.firstFrom4;
                        break;
                    case 2:
                        position = Points.secondFrom4;
                        break;
                    case 3:
                        position = Points.thirdFrom4;
                        break;
                    case 4:
                        position = Points.fourthFrom4;
                        break;
                }
                break;
            case 5:
                switch (who){
                    case 1:
                        position = Points.firstFrom5;
                        break;
                    case 2:
                        position = Points.secondFrom5;
                        break;
                    case 3:
                        position = Points.thirdFrom5;
                        break;
                    case 4:
                        position = Points.fourthFrom5;
                        break;
                    case 5:
                        position = Points.fifthFrom5;
                        break;
                }
                break;
            case 6:
                switch (who){
                    case 1:
                        position = Points.firstFrom6;
                        break;
                    case 2:
                        position = Points.secondFrom6;
                        break;
                    case 3:
                        position = Points.thirdFrom6;
                        break;
                    case 4:
                        position = Points.fourthFrom6;
                        break;
                    case 5:
                        position = Points.fifthFrom6;
                        break;
                    case 6:
                        position = Points.sixthFrom6;
                        break;
                }
                break;
        }
        return position;
    }*/
}
