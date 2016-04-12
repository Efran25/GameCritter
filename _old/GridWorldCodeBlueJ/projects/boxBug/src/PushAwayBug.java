/**
 * Created by Efran25 on 3/21/2016.
 */

import info.gridworld.actor.*;
        import info.gridworld.grid.*;
        import java.awt.*;
        import java.util.*;

public class PushAwayBug extends Bug {
    public PushAwayBug() {
        setColor(Color.GRAY);
    }

    public void act() {

        for(Actor a : getGrid().getNeighbors(getLocation())) {

          for(Location b : getGrid().getEmptyAdjacentLocations(a.getLocation())) {
              int checker = 0;

              for(Location c : getGrid().getOccupiedAdjacentLocations(b)) {
                  if(c.compareTo(this.getLocation()) == 0)
                      checker = 1;
              }

              if(checker == 0)
                  a.moveTo(b);
          }
        }
        if (canMove()) {
            move();
        }
        else
            turn();

    }
}