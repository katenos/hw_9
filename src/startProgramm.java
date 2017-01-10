
import controller.BattleConrtoller;
import controller.BattleControllerImpl;
import model.BattleModel;
import model.BattleModelImpl;
import view.MainFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kate_
 */
public class startProgramm {   
    public static void main(String[] args) throws Exception {       
//        new MainFrame().setVisible(true);
        BattleModel battleModel=new BattleModelImpl();
        BattleConrtoller controller=new BattleControllerImpl(battleModel);
    }
}
