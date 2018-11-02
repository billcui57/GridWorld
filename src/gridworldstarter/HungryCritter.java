/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworldstarter;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 *
 * @author 348848128
 */
public class HungryCritter extends Critter {

    public static final int STOMACH_SIZE = 5 /* a positive number */;
    public static final int NECK_SIZE = 2/* a positive number */;
    public static final int MAX_HUNGRY_STEPS = 3/* a positive number */;
    public int eaten=0;
    public int hungrySteps=0;
//    
  
    /**
     * Gets the number of neighboring actors that within the neck size radius of the critter
     * @return the actors
     */
    public ArrayList<Actor> getActors() {

        ArrayList<Actor> actors = new ArrayList<Actor>();
      
        //With in a neck size radius of the critter
        for (int y = -NECK_SIZE; y <= NECK_SIZE; y++) {
            for (int x = -NECK_SIZE; x <= NECK_SIZE; x++) {
                try {
                    //tests each location within the neck radius and if there is an actor that is an instance of flower
                    //there then add that actor to arraylist
                    Location testLocation = new Location(this.getLocation().getRow() + y, this.getLocation().getCol() + x);

                    Actor test = getGrid().get(testLocation);
                    
                    if ((sameLocation(test.getLocation(), testLocation)) && (test instanceof Flower) ) {
                        actors.add(test);
                    }
                } catch (java.lang.NullPointerException e) {

                }
            }
        }

        
        return actors;
    }

    /**
     * Helper method that checks if two locations are the same location
     * @param test1 location 1
     * @param test2 location 2
     * @return boolean whether or not they are the same location
     */
    public boolean sameLocation(Location test1, Location test2) {
        //if they are the same location then return true
        
        if ((test1.getCol() == test2.getCol()) && (test1.getRow() == test2.getRow())) {
            return true;
        } 
        //else return false
        else {
            return false;
        }
    }
    
    /**
     * 
     * @param flowers all the flower actors that are around the critter within neck radius
     */
    public void processActors(ArrayList<Actor> flowers) {
        
         //gets each flower actor and removes it from the grid 
        for(int i=0;i<flowers.size();i++){
  
            if(eaten<STOMACH_SIZE){
            flowers.get(i).removeSelfFromGrid();
            flowers.get(i).act();
            //increments eaten count
            eaten++;
            }
            
           
            
        }
         flowers.clear();
        
    }
    
    /**
     * Critter's move method and also self evaluation
     * @param loc critter location that is to be moved to
     */
     public void makeMove(Location loc) {
         
         //if critter is still hungry, then increment number of hungry steps
         if(eaten<STOMACH_SIZE){
             hungrySteps++;
             this.moveTo(loc);
         }else if(eaten==STOMACH_SIZE){
                hungrySteps=0;
         }
         
         //if critter has had more than the max number of hungry steps, then the critter dies
         eaten=0;
         if(hungrySteps>=MAX_HUNGRY_STEPS){
             this.removeSelfFromGrid();
         
     }
//    public ArrayList<Actor> getActors() {
//        ArrayList<Actor> temp = new ArrayList<Actor>;
//        return 
//    }
}
}
