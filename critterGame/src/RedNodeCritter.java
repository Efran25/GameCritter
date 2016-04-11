/**
 * Created by ehimel16 on 4/7/2016.
 */
/**
 * Created by user on 4/7/2016.
 */
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;

import java.awt.*;

public class RedNodeCritter  extends Critter{
    private Location home = new Location(0,0);

    public void act(){
        LinkedList<FlowerNode> flowers = getFlowers();
        if (flowers.size() == 0){
            makeMove(home);
            //if(getLocation().getRow() == home.getRow() && getLocation().getCol() == home.getCol())
               // makeFlowers();
        }
        else {
            Location floc = flowers.getFirst().getLocation();
            makeMove(floc);
        }
    }

    private LinkedList<FlowerNode> getFlowers()
    {
        Grid gr = getGrid();
        LinkedList<FlowerNode> temp = new LinkedList<FlowerNode>();
        for(Location a : (ArrayList<Location>) gr.getOccupiedLocations())
        {
            if(gr.get(a) instanceof Flower)
            {
                temp.add(new FlowerNode(a));
            }
        }
        return temp;
    }

    public void makeMove(Location floc)
    {
        setDirection(getLocation().getDirectionToward(floc));
        Grid gr = getGrid();
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);

    }
/*
    public void makeFlowers() {
        ArrayList<Flower> flowerList = new ArrayList<>();
        int max = ((int) ((Math.random() * 12) + 4));
        for (int i = 0; i < max; i++) {
            Flower fl = new Flower();
            flowerList.add(fl);
        }
        for (Actor a : flowerList) {
            Location randomLoc = new Location((((int) (Math.random() * 9))), (((int) (Math.random() * 9))));
            while(getGrid().isValid(randomLoc) == false || getGrid().get(randomLoc) != null)
            {
                randomLoc = new Location((((int) (Math.random() * 9))), (((int) (Math.random() * 9))));
            }
            a.putSelfInGrid(getGrid(), randomLoc);
        }
        flowerList.clear();
    }
    */
}

