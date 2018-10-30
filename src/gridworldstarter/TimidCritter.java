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
    private static final int MAX_EXPLORATION_STEPS=10;
    private ArrayList<Location> exploredLocations = new ArrayList<Location>();
    int exploredSteps=0;
         int toRetractSteps=0;
         boolean runOnce=true;
         
     public void makeMove(Location loc) {
          if(runOnce){
              exploredLocations.add(this.getLocation());
              runOnce=false;
          }
         
          if(exploredSteps<MAX_EXPLORATION_STEPS){
              exploredLocations.add(loc);
               this.moveTo(loc);
               exploredSteps++;
               toRetractSteps=exploredSteps;
          }else if (exploredSteps>=MAX_EXPLORATION_STEPS){
              System.out.println("retracting");
              this.moveTo(exploredLocations.get(toRetractSteps-1));
              toRetractSteps--;
              if(toRetractSteps-1<0){
                  exploredLocations.clear();
                  System.out.println("done");
                  exploredSteps=0;
                  toRetractSteps=0;
                  runOnce=true;
              }
          }
        
          
     }
     
   public void processActors(ArrayList<Actor> inTheWay) {
      
    
}
