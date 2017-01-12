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
public class Viking extends Warrior implements  Cloneable {

    public Viking(String name) {        
        this.health = 100;
        this.damage = 30;
        this.warriorName = name;
    }
    
    public Viking() {        
        this.health = 100;
        this.damage = 30;
        this.warriorName = "Viking";
    }

    @Override
    public String toString() {
        String str = "Викинг: имя " + this.warriorName + ", " + this.squadName + ", "
                + "здоровье " + this.health + ", урон " + this.damage;
        return str;
    }    
}
