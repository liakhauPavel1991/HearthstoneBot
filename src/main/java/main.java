import imageTools.ScreenUtil;
import monitorActions.*;

import java.awt.*;
import java.io.*;
import java.util.Date;

public class main {
    public static void main(String[] args) throws IOException, AWTException, ClassNotFoundException {
        Manager manager = new Manager();
        manager.sleep(1000);

        while (true){
            int i =1;
            System.out.println("--------------------------------------" + new Date());
            manager.prepareNewCycle(7);
            manager.choseBattle();
            manager.choseCommand();
            while(manager.findBestEnemy() > 0){
                manager.startBattle();
                manager.opening(4, 1, 3, 4);
                manager.turn();
                manager.prepareBattle();
                manager.fight();
                manager.acceptWin();
                manager.takePower();
            }
            if(manager.continueCycle){
                manager.startBattle();
                manager.opening(4, 1, 3, 4);
                manager.turn();
                manager.prepareBattle();
                manager.fight();
                manager.acceptWin();
                manager.getPrizes(i);
            }
        }

    }

/*

    private static void takeScreen() throws IOException, AWTException {

        String fileName = "portalImage";
        Rectangle myNameLblStr = new Rectangle(1450, 280, 100, 100);
        ScriptCreator.create(fileName, myNameLblStr);
    }


*/


}






