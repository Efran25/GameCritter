import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Efran25 on 3/21/2016.
 */

public class BattleBug extends Bug{
    public BattleBug() {
        setColor(Color.YELLOW);
    }

    public void act() {
        ArrayList<Location> bugList = getGrid().getOccupiedAdjacentLocations(getLocation());

        for (Location a: bugList) {
            if (getGrid().get(a) instanceof Bug && getGrid().get(a).getColor() != getColor()) {
                battle(a);
                break;
            }
        }

        if (canMove()) {
            move();
        }
        else
            turn();

    }

    private void battle(Location a) {
        int battle = ((int)((Math.random() * 10) + 1));
        System.out.println(battle);
        if(battle < 6) {
            removeSelfFromGrid();
        }
        else if (battle >= 6){
            moveTo(a);

        }
    }
}
