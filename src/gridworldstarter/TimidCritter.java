/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworldstarter;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 *
 * @author 348848128
 */
public class TimidCritter extends Critter {
    private int maxExplorationSteps=10;
    private ArrayList<Location> exploredLocations = new ArrayList<Location>();
    int exploredSteps=0;
         int toRetractSteps=0;
         boolean runOnce=true;
         
         public TimidCritter(int newMaxExplorationSteps){
             maxExplorationSteps=newMaxExplorationSteps;
         }
         
         /**
          * Moves to location and retracts back
          * @param loc location to move to
          */
     public void makeMove(Location loc) {
         //adds first location as its last location to retract to
          if(runOnce){
              exploredLocations.add(this.getLocation());
              runOnce=false;
          }
         
          //When it is exploring, then it will add each step that it had moved to in an arraylist
          if(exploredSteps<maxExplorationSteps){
              exploredLocations.add(loc);
               this.moveTo(loc);
               exploredSteps++;
               toRetractSteps=exploredSteps;
          }
          //When retracting, it will move to each step beginning from the end of the arraylist 
          else if (exploredSteps>=maxExplorationSteps){
              System.out.println("retracting");
              this.moveTo(exploredLocations.get(toRetractSteps-1));
              toRetractSteps--;
              //done retracting
              if(toRetractSteps-1<0){
                  exploredLocations.clear();
                  System.out.println("done");
                  exploredSteps=0;
                  toRetractSteps=0;
                  runOnce=true;
              }
          }
        
          
     }
     
//No need for manual check for if an actor is in the way, since default parent critter will eat it anyways
      
    
}
