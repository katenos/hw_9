/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.UnsupportedLookAndFeelException;
import model.BattleModel;
import view.MainFrame;
import model.Squad;

/**
 *
 * @author kate_
 */
public class BattleControllerImpl implements BattleConrtoller {
    
    private BattleModel model;
    private MainFrame view;
    private Squad sq1, sq2;
    
    public BattleControllerImpl(BattleModel model) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ClassNotFoundException {
        this.model = model;
        view = new MainFrame(this, model);
        sq1 = new Squad("Отряд 1");
        sq2 = new Squad("Отряд 2");
    }
    
    @Override
    public void start(String nameSq1, String nameSq2) {
        String noError = fieldsFill(nameSq1, nameSq2);        
        view.changeStartButton(false);
        if (noError.equals("")) {
            view.updateMessage("", "");
            sq1.rename(nameSq1);
            sq2.rename(nameSq2);
            sq1.changeSquadNameOfWarrior();
            sq2.changeSquadNameOfWarrior();
            model.start(sq1, sq2);
        } else {
            view.updateMessage("", noError);
        }        
    }
    
    @Override
    public void addWarrior(String nameWarrior, int ind, String typeWarrior) {
        String msg = "", error = "";
        if (!nameWarrior.equals("")) {
            model.addWarrior(typeWarrior, getSelectedSquad(ind));
            getSelectedSquad(ind).getSquad().get(getSelectedSquad(ind).getSquad().size() - 1).setName(nameWarrior);
            msg = "Боец добавлен";
        } else {
            error = "Введите имя бойца";
        }
        view.updateMessage(msg, error);
    }
    
    @Override
    public String[] getTypeWarrior() {
        return model.getTypeWarrior();
    }
    
    private Squad getSelectedSquad(int ind) {
        if (ind == 0) {
            return sq1;
        } else {
            return sq2;
        }
    }
    
    private String fieldsFill(String nameSq1, String nameSq2) {
        StringBuilder error = new StringBuilder();        
        if (nameSq1.equals("")) {
            error.append("Введите имя первого отряда. ");            
        }
        if (nameSq2.equals("")) {
            error.append("Введите имя второго отряда. ");
        }
        if (sq1.getSquad().size() == 0) {
            error.append("В первом отряде нет бойцов! ");
        }
        if (sq2.getSquad().size() == 0) {
            error.append("Во втором отряде нет бойцов! ");
        }
        return error.toString();
    }
    
}
