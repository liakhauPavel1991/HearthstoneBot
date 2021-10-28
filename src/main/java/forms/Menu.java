package forms;

import utils.readers.PropertyReader;

import java.awt.*;

public class Menu extends BaseForm{
    private static final int choseBattleLoading = 5000;
    private static final Rectangle menuBtn = new Rectangle(1860, 1050, 10, 10);
    private static final Rectangle surrenderBtn = new Rectangle(950, 370, 20, 10);

    private static final String menuBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "menuBtn");
    private static final String surrenderBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "surrenderBtn");

    public void surrender(){
        robot.move(menuBtn);
        robot.click();
        sleep(300);
        robot.move(surrenderBtn);
        robot.click();
        sleep(1000);
        robot.click();
        sleep(choseBattleLoading);
    }

    public boolean isMenuHere(){
        return isExist(menuBtnStr, menuBtn);
    }

    public boolean isSurrenderButtonExist(){
        if(isMenuHere()){
            robot.move(menuBtn);
            robot.click();
            sleep(500);
        }
        boolean is = isExist(surrenderBtnStr, surrenderBtn);
        robot.move(menuBtn);
        return is;
    }
}
