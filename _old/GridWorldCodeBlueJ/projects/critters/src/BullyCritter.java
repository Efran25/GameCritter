/**
 * Created by Efran25 on 3/22/2016.
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;
import java.awt.*;

public class BullyCritter extends ChameleonCritter {
    public BullyCritter() {
        setColor(Color.BLACK);
    }

    public void processActors(ArrayList<Actor> actors) {
        for (Actor a: getGrid().getNeighbors(getLocation())) {
            a.setColor(getColor());
        }
    }
}
