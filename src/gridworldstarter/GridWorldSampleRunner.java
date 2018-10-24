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
        Bug xman = new Bug();
        //add a BoxBug to 30,30
        BoxBug buggy = new BoxBug(5);
        world.add(new Location(4,4),buggy);
        
        world.add(new Location(5, 5), xman);
        
        world.add(new Location(3,3),new Critter());
        
        //add a Chameleon Critter to 8,8
        ChameleonCritter crit = new ChameleonCritter();
        world.add(new Location(8,8),crit);
        
        
        if (world.getGrid().isValid(new Location(4,4))){
            System.out.println("Asdf");
        }
        world.show();
        
        xman.setDirection(45);
        xman.moveTo(new Location(3,3));
        xman.setDirection(225);
        
        SBug beener = new SBug(5);
        world.add(new Location(2,2),beener);
       
        ObliteratorCritter ob = new ObliteratorCritter();
        world.add(new Location(9,9),ob);

    }
    
   
}
