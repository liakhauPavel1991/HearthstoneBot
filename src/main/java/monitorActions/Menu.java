package monitorActions;

import utils.readers.PropertyReader;

import java.awt.*;

interface Menu extends BaseForm{
    int choseBattleLoading = 5000;
    Rectangle menuBtn = new Rectangle(1860, 1050, 10, 10);
    Rectangle surrenderBtn = new Rectangle(950, 370, 20, 10);

    String menuBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "menuBtn");
    String surrenderBtnStr = PropertyReader.getProperty(PropertyReader.dataFilePath, "surrenderBtn");

    default void surrender(){
        robot.move(menuBtn);
        robot.click();
        sleep(300);
        robot.move(surrenderBtn);
        robot.click();
        sleep(1000);
        robot.click();
        sleep(choseBattleLoading);
    }

    default boolean isMenuHere(){
        return isThatImageExist(menuBtnStr, menuBtn);
    }

    default boolean isSurrenderButtonExist(){
        if(isMenuHere()){
            robot.move(menuBtn);
            robot.click();
            sleep(500);
        }
        boolean is = isThatImageExist(surrenderBtnStr, surrenderBtn);
        robot.move(menuBtn);
        robot.click();
        return is;
    }
}
