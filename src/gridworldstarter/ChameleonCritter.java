/*
 * Q1:
 */
package gridworldstarter;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonCritter extends Critter {

    /**
     * This <code>DARKENING_FACTOR</code> is, by default, set to one half. It is
     * used to darken the color of the chameleon.
     */
    private static final double DARKENING_FACTOR = 0.5;

    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors
     */
    public void processActors(ArrayList<Actor> actors) {
        int n = actors.size();
        if (n == 0) {
            return;
        }
        int r = (int) (Math.random() * n);
        Actor other = actors.get(r);
        setColor(other.getColor());

    }

    /**
     * Turns towards the new location as it moves. Otherwise keeps default
     * makeMove behaviour
     */
    public void makeMove(Location loc) {
        //add a comment to describe what this does
        setDirection(getLocation().getDirectionToward(loc));
        //Q2 add a comment to describe what this does and why?
        super.makeMove(loc);
        //Q3 what would you need to do to make it drop flowers?
        
    }

    /**
     * Darkens the color of the chameleon by the specified darkening factor of
     * one half.
     */
    private void darken() {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    }
}
