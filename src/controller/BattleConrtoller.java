/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author kate_
 */
public interface BattleConrtoller {
    void start(String nameSq1, String nameSq2);
    void addWarrior(String nameWarrior, int ind, String typeWarrior);    
    String[] getTypeWarrior();
}
