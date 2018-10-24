/*
 * Q5: It is only possible to change the size of the square within BoxBug class, as it is a private variable, and there are no setters for that.
 * Q6: The value of steps will be 0 after the boxbug has turned 90 degrees and before it has proceeded to move forward in the next dimension.
       The value of steps will be 0 also after boxbug has been constructed and has no acted yet (act() not run yet)
 */
package gridworldstarter;

import info.gridworld.actor.Bug;

public class BoxBug extends Bug
{
   //Q2 what does this do?
    //Counts the side length that was already walked by bug to ensure that it is only walking the side length entered
    private int steps;
    //Q1 What does this do?
    //Sets the sidelength of the box that is traced out by bug
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public BoxBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        
        if (steps < sideLength && canMove())
        {
            //Q4 but there is no move method?
            //It is a subclass of bug by extending it. This means that it has inherited its methods.
            move();
            steps++;
        }
        else
        {
            //Q3 why is this called twice?
            //Since running turn() once makes bug turn 45 degrees, running it twice makes it turn 90 degrees to draw a box
            turn();
            turn();
            steps = 0;
        }
    }
}