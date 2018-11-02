/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworldstarter;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
/**
 *
 * @author michael.roy-diclemen
 */
public class GridWorldSampleRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {



        ActorWorld world = new ActorWorld(new UnboundedGrid<>());
        BoxBug xman = new BoxBug(2);
        //add a BoxBug to 30,30
        BoxBug buggy = new BoxBug(2);
        world.add(new Location(4,4),buggy);
       
       
        
        world.add(new Location(0, 0), xman);
        
        
        world.add(new Location(11,11), new Rock());
        
        //add a Chameleon Critter to 8,8
        ChameleonCritter crit = new ChameleonCritter();
        world.add(new Location(8,8),crit);
        
        
        if (world.getGrid().isValid(new Location(4,4))){
            System.out.println("Asdf");
        }
        world.show();
        
        
        HungryCritter hungry = new HungryCritter();
        world.add(new Location(1,1), hungry);
        
       
        
        SBug beener = new SBug(5);
        world.add(new Location(2,2),beener);
       
        ObliteratorCritter ob = new ObliteratorCritter();
        world.add(new Location(7,7),ob);
     
       
        

    }
    
   
}
