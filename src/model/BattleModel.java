/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.BattleObserver;

/**
 *
 * @author kate_
 */
public interface BattleModel {

    String[] getTypeWarrior();

    void start(Squad sq1, Squad sq2);

    void addWarrior(String typeWarrior, Squad squad);

    void registerObserver(BattleObserver o);

    void removeObserver(BattleObserver o);

    void notifyObservers();

}
