/**
 * Created by Efran25 on 3/22/2016.
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;
import java.awt.*;

public class CrossCritter extends ChameleonCritter{
    public CrossCritter() {
        setColor(Color.cyan);
    }

    public ArrayList<Actor> getActors() {
        int row = 0;
        int col = 0;

        ArrayList<Actor> actorList = new ArrayList<>();

        while(row < getGrid().getNumRows()-1 && col < getGrid().getNumCols()-1) {
            Location loc1 = new Location(row, getLocation().getCol());
            Location loc2 = new Location(getLocation().getRow(), col);

            if(getGrid().get(loc1) instanceof Actor && loc1.compareTo(getLocation()) != 0 && getGrid().isValid(loc1)) {
                actorList.add(getGrid().get(loc1));
            }

            if(getGrid().get(loc2) instanceof Actor && loc2.compareTo(getLocation()) != 0 && getGrid().isValid(loc2)) {
                actorList.add(getGrid().get(loc2));
            }

            row++;
            col++;
        }
        return actorList;
    }

    public void processActors(ArrayList<Actor> actors) {
        for (Actor a: actors) {
            a.setColor(getColor());
        }
    }
}
