
import controller.BattleConrtoller;
import controller.BattleControllerImpl;
import model.BattleModel;
import model.BattleModelImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class StartProgramm {
      public static void main(String[] args) throws Exception { 
        BattleModel battleModel=new BattleModelImpl();
        BattleConrtoller controller=new BattleControllerImpl(battleModel);
    }
}
