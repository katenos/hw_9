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
public class WarriorCreator {
    private String [] types={"Viking", "Archer"};
    
    public String[] getTypes(){   
        return types;
    }  

    public Warrior getWarrior(String type) {       
        switch (type) {
            case ("Archer"):
                return new Archer();
            case ("Viking"):
                return new Viking();
        }
        return null;
    }
}
