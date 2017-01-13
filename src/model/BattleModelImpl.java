/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import view.BattleObserver;

/**
 *
 * @author kate_
 */
public class BattleModelImpl implements BattleModel {

    private WarriorCreator warrior= new WarriorCreator();
    private StringBuilder outputInfo;
    private List<BattleObserver> observers = new ArrayList<>();

    @Override
    public String[] getTypeWarrior() {
        return warrior.getTypes();
    }

    @Override
    public void start(Squad sq1, Squad sq2) {
        outputInfo = outputCreatbleInfo(sq1, sq2);
        notifyObservers();
    }

    @Override
    public void addWarrior(String typeWarrior, Squad squad) {
        squad.addWarrior(warrior.getWarrior(typeWarrior));
    }

    @Override
    public void registerObserver(BattleObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(BattleObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach((battleObserver) -> battleObserver.updateResult(outputInfo.toString()));
    }

    public StringBuilder outputCreatbleInfo(Squad sq1, Squad sq2) {
        StringBuilder strBResult = new StringBuilder();
        DateHelper d = new DateHelper();
        strBResult.append("Список бойцов\n");
        sq1.getSquad().forEach(sq -> strBResult.append(sq.toString()).append("\n"));
        strBResult.append("\n");
        sq2.getSquad().forEach(sq -> strBResult.append(sq.toString()).append("\n"));
        strBResult.append("\nСражение началось!\n");
        strBResult.append(d.getFormattedStartDate());
        strBResult.append(battle(sq1, sq2, d));
        return strBResult;
    }

    private StringBuilder battle(Squad ot1, Squad ot2, DateHelper d) {
        StringBuilder strBResult = new StringBuilder();
        int i = 0;
        String nameWinner = "";
        while (nameWinner.equals("")) {
            strBResult.append("\nРаунд ").append(++i);
            strBResult.append(attackRound(ot1, ot2, d));            
            if (!ot2.hasAliveWarriors()) {
                nameWinner = ot1.toString();
                break;
            }
            strBResult.append(attackRound(ot2, ot1, d));//это не такая же строка, выше сперва от1 потом от2, а здесь наоборот
            //если вы про  d.skipTime(); то перенесла его в метод attackRound
            //имею в виду все эти строки. они отличаются только расположением ot1 и ot2. это можно вынести в отдельный метод и вызвать два раза, что-то вроде attack(ot1, ot2); attack(ot2, ot1)
            if (!ot1.hasAliveWarriors()) {
                nameWinner = ot2.toString();
                break;
            }
        }
        strBResult.append("\nПобедил ").append(nameWinner);
        strBResult.append("\nОбщее время поединка ").append(d.getFormattedDiff());
        return strBResult;
    }

    private StringBuilder attackRound(Squad ot1, Squad ot2, DateHelper d) {
        Warrior w1 = ot1.getRandomWarrior();
        Warrior w2 = ot2.getRandomWarrior();
        StringBuilder strBResult = new StringBuilder();
        strBResult.append("\nБоец - ").append(w1.toString()).append(" атакует бойца\n       ").append(w2.toString());
        w2.takeDamage(w1.attack());
        d.skipTime();
        return strBResult;
    }

}
