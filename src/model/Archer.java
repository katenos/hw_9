/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author kate_
 */
public class Archer extends Warrior{

    public Archer(String name) {
        this.health = 70;
        this.damage = 40;
        this.warriorName = name;
    }

    public Archer() {
        this.health = 70;
        this.damage = 40;
        this.warriorName = "Archer";
    }

    @Override
    public String toString() {
        String str = "Лучник: имя " + this.warriorName + ", " + this.squadName + ", "
                + "здоровье " + this.health + ", урон " + this.damage;
        return str;
    }
}
