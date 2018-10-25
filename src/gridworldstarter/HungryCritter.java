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

//    
//    @Override
    public ArrayList<Actor> getActors() {

        ArrayList<Actor> actors = new ArrayList<Actor>();
      

        for (int y = -NECK_SIZE; y < NECK_SIZE; y++) {
            for (int x = -NECK_SIZE; x < NECK_SIZE; x++) {
                try {
                    Location testLocation = new Location(this.getLocation().getRow() + y, this.getLocation().getCol() + x);

                    Actor test = getGrid().get(testLocation);

                    if ((sameLocation(test.getLocation(), testLocation)) && (test instanceof Flower) ) {
                        actors.add(test);
                    }
                } catch (java.lang.NullPointerException e) {

                }
            }
        }

        System.out.println(actors.size());

        for (int i = 0; i < actors.size(); i++) {
            System.out.println(actors.get(i).toString());
        }
        return actors;
    }

    public boolean sameLocation(Location test1, Location test2) {
        if ((test1.getCol() == test2.getCol()) && (test1.getRow() == test2.getRow())) {
            return true;
        } else {
            return false;
        }
    }

    public void processActors(ArrayList<Actor> actors) {

        for(int i=0;i<actors.size();i++){
            actors.get(i).removeSelfFromGrid();
            actors.remove(i);
        }
    }
//    public ArrayList<Actor> getActors() {
//        ArrayList<Actor> temp = new ArrayList<Actor>;
//        return 
//    }
}
