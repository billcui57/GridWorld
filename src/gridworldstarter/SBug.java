/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridworldstarter;

import info.gridworld.actor.Bug;

/**
 *
 * @author 348848128
 */
public class SBug extends Bug {

    private int Slength;
    private int step;
    private int phase;

    /**
     * Constructor for bug with length determinator
     * @param length 
     */
    public SBug(int length) {
        Slength = length;
        step = 0;
        phase = 0;
        this.setDirection(270);
    }

    /**
     * Act method for the bug to move in an S pattern
     */
    @Override
    public void act() {

        //three phases for the three strokes to draw S
        switch (phase) {
            case 0:
                    this.setDirection(270);
                break;
            case 1:
                    this.setDirection(135);
                break;
            case 2:
                    this.setDirection(270);
                break;
        }
        
        //if the bug has moved the maximum length of the S, then it proceeds to next stroke
        if (step < Slength && this.canMove() && phase<=2) {
                    this.move();
                    step++;
                } else {
                    phase++;
                    step=0;
         }

    }
}
