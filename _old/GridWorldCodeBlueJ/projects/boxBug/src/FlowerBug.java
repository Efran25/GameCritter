/**
 * Created by Efran25 on 3/21/2016.
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class FlowerBug extends Bug{
    public FlowerBug() {
        setColor(Color.GREEN);
    }

    public void act() {
        ArrayList<Location> rockList = getGrid().getOccupiedAdjacentLocations(getLocation());

        for (Location a: rockList) {
            if (getGrid().get(a) instanceof Rock) {
                getGrid().get(a).removeSelfFromGrid();
                Flower flower = new Flower(getColor());
                flower.putSelfInGrid(getGrid(), a);
            }
        }
        if (canMove()) {
            move();
        }
        else
            turn();
    }
}
