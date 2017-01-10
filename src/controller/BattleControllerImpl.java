/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.BattleModel;
import view.MainFrame;
/**
 *
 * @author kate_
 */
public class BattleControllerImpl implements BattleConrtoller{
    
    private BattleModel model;
    private MainFrame view;
    
    public BattleControllerImpl(BattleModel model) {
        this.model = model;
        view = new MainFrame(this, model);
    } 
    
    @Override
    public void start() {
       
    }

    @Override
    public void addWarrior() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
