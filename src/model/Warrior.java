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
public abstract class Warrior implements Cloneable{

    protected int health;
    protected int damage;
    protected String squadName;
    protected String warriorName;

    public int attack() {
        return this.damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void setSquadName(String name) {
        this.squadName = name;
    }

    public void setName(String name) {
        this.warriorName = name;
    }

    @Override
    public Warrior clone() throws CloneNotSupportedException {       
        return (Warrior) super.clone();
    }
    
    public abstract String getTypeWarrior();  //зачем этот метод?
}
