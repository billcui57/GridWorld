/*
 * Q5:
 * Q6:
 */
package gridworldstarter;

import info.gridworld.actor.Bug;

public class BoxBug extends Bug
{
   //Q2 what does this do?
    private int steps;
    //Q1 What does this do?
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
            move();
            steps++;
        }
        else
        {
            //Q3 why is this called twice?
            turn();
            turn();
            steps = 0;
        }
    }
}