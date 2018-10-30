/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworldstarter;

import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import java.util.ArrayList;

/**
 *
 * @author 348848128
 */
public class ObliteratorCritter extends Critter {
    public void processActors(ArrayList<Actor> actors) {
        for(int i=0;i<actors.size();i++){
            if(!((actors.get(i))instanceof Critter)){
                actors.get(i).removeSelfFromGrid();
                
                
            }
        }
        
        actors.clear();
        
       
       
        

    }
}
