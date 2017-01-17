package model;

import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kate_
 */
public class Squad {

    private String name;
    private ArrayList<Warrior> squad = new ArrayList<Warrior>();
    private Random rand = new Random();

    public Squad(String name) {
        this.name = name;
    }

    public ArrayList<Warrior> getSquad() {
        return squad;
    }

    public void addWarrior(Warrior warrior) {
        squad.add(warrior);
        warrior.setSquadName(this.name);
    }

    public Warrior getRandomWarrior() {
        Warrior warrior;
        do {
            warrior = squad.get(rand.nextInt(squad.size()));
        } while (!warrior.isAlive());
        return warrior;
    }

    public boolean hasAliveWarriors() {
        for (int i = 0; i < squad.size(); i++) {
            if (squad.get(i).isAlive()) {
                return true;
            }
        }
        return false;
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public void changeSquadNameOfWarrior() {
        squad.forEach(warrior -> warrior.setSquadName(name));
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public Squad clone() throws CloneNotSupportedException { //странно что неправильное клонирование было, я видимо случайно не из того проекта скопировала его
        //т.к. в hw_4_2 клонирование работает верно
        Squad clone = (Squad) super.clone();
        ArrayList<Warrior> arWarrior = new ArrayList<Warrior>();
        for (int i = 0; i < squad.size(); i++) {
            arWarrior.add(squad.get(i).clone());
        }
        clone.squad = arWarrior;
        return clone;
    }

}
