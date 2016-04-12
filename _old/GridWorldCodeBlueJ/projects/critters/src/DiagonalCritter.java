/**
 * Created by Efran25 on 3/22/2016.
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;
import java.awt.*;

public class DiagonalCritter extends ChameleonCritter{
    public DiagonalCritter() {
        setColor(Color.ORANGE);
    }

    public ArrayList<Actor> getActors() {
        int rowa = getLocation().getRow()-1;
        int cola = getLocation().getCol()-1;
        int colb = getLocation().getCol()+1;
        int rowb = getLocation().getRow()+1;

        ArrayList<Actor> actorList = new ArrayList<>();

        while(rowa > -1 && cola > -1 && colb < getGrid().getNumCols() && rowb < getGrid().getNumRows()) {
            Location loc1 = new Location(rowa, cola);
            Location loc2 = new Location(rowa, colb);
            Location loc3 = new Location(rowb, colb);
            Location loc4 = new Location(rowb, cola);

            if(getGrid().get(loc1) instanceof Actor && getGrid().isValid(loc1)) {
                actorList.add(getGrid().get(loc1));
            }
            if(getGrid().get(loc2) instanceof Actor && getGrid().isValid(loc2)) {
                actorList.add(getGrid().get(loc2));
            }
            if(getGrid().get(loc3) instanceof Actor && getGrid().isValid(loc3)) {
                actorList.add(getGrid().get(loc3));
            }
            if(getGrid().get(loc4) instanceof Actor && getGrid().isValid(loc4)) {
                actorList.add(getGrid().get(loc4));
            }

            rowa--;
            cola--;
            if(rowa == -1)
                rowa++;
            if(cola == -1)
                cola++;
            rowb++;
            colb++;
        }
        System.out.println("Row A: " + rowa);
        System.out.println("Row B: " + rowb);
        System.out.println("Col A: " + cola);
        System.out.println("Col B: " + colb);
        return actorList;
    }

    public void processActors(ArrayList<Actor> actors) {
        for (Actor a: actors) {
            a.setColor(getColor());
        }
    }
}
