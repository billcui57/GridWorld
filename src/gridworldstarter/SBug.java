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

    public SBug(int length) {
        Slength = length;
        step = 0;
        phase = 0;
        this.setDirection(270);
    }

    public void act() {

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
        
        if (step < Slength && this.canMove() && phase<=2) {
                    this.move();
                    step++;
                } else {
                    phase++;
                    step=0;
         }

    }
}
