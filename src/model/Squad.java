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
public class Squad implements Cloneable {

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
    public Squad clone() throws CloneNotSupportedException {
        Squad clone = (Squad) super.clone();
        ArrayList<Warrior> clonedSquad = new ArrayList<>();
        for (Warrior warrior : squad) {
            clonedSquad.add(warrior.clone());
        }
        clone.squad = clonedSquad;
        clone.squad = (ArrayList<Warrior>) squad.clone(); //что это?
        return clone;
    }
}
