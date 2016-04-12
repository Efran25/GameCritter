/**
 * Created by Efran25 on 3/21/2016.
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class WarpBug extends Bug{
    private boolean danger = false;

    public WarpBug() {
        setColor(Color.MAGENTA);
    }

    public void act() {
        if (canMove()) {
            if(checkCritter())
                warp();
            else
                move();
        }
        else
            turn();

    }

    private void warp() {
        int checker = 0;
        while (danger) {
            Location next = new Location(((int)((Math.random() * 9) + 1)),((int)((Math.random() * 9) + 1)));
            checker = 0;

            for (Actor a : getGrid().getNeighbors(next)) {
                if (a instanceof Critter) {
                 checker = 1;
                    break;
                }
            }
            if (checker == 0) {
                danger = false;
                moveTo(next);
            }
        }
    }

    public boolean checkCritter() {
        ArrayList<Location> critterList = getGrid().getOccupiedAdjacentLocations(getLocation());
        for (Location a : critterList) {
            if (getGrid().get(a) instanceof Critter) {
                danger = true;
                warp();
                return true;
            }
        }
        return false;
    }
}
