package com.efran.gridworld;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.*;

/**
 * Created by Efran25 on 3/31/2016.
 */
public class RedCritter extends Critter{
    private Location home = new Location(0,0);
    public RedCritter() {
        setColor(Color.red);
    }

    public void act()
    {
        Location floc = getFlower();

        setDirection(getLocation().getDirectionToward(floc));
        makeMove();
    }

    private Location getFlower()
    {
        Grid gr = getGrid();
        ArrayList<Location> temp = gr.getOccupiedLocations();
        for(Location l : temp)
        {
            if(gr.get(l) instanceof Flower)
            {
                return l;
            }
        }
        return home;
    }

    private void makeMove()
    {
        Grid gr = getGrid();
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);

    }
}
