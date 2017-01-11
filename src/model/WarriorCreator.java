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
public class WarriorCreator { //у вас же был вариант с клонированием прототипов, и он был намного лучше
    private String [] types={"Viking", "Archer"}; //сейчас при изменении классов бойцов придется менять это...
    
    public String[] getTypes(){   
        return types;
    }  

    public Warrior getWarrior(String type) {    
        switch (type) {
            case ("Archer"):
                return new Archer();
            case ("Viking"):
                return new Viking(); //...и переписывать эти кейсы. а в предыдущей реализации достаточно было изменить список прототипов и все
        }
        return null;
    }
}
