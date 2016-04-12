/**
 * Created by ehimel16 on 4/7/2016.
 */
/**
 * Created by user on 4/7/2016.
 */
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import sun.util.resources.cldr.om.LocaleNames_om;

import java.util.*;

import java.awt.*;

public class RedNodeCritter  extends Critter{
    private Location home = new Location(0,0);

    public void act(){
        LinkedList <FlowerNode> flowers = getFlowers();
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

        ArrayList<Location> locList = gr.getOccupiedLocations();

        // sortList(locList);

        for(Location a : locList)
        {
            if(gr.get(a) instanceof RedFlower)
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
 QuickSort Implementation
    public ArrayList<Location> sortList(ArrayList<Location> loc) {
        System.out.print(loc);

        quickSort(loc);

    }



    public ArrayList<Location> quickSort(ArrayList<Location> loc) {
        if(loc == null || loc.size() == 0)
            return loc;

        int middle = (int) Math.ceil((double)loc.size()/2);
        Location pivot = loc.get(middle);

        List <Location> less = new ArrayList<Location>();

    }
    */
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

