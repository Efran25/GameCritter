import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;

public class ChameleonCritter extends Critter {
    public ChameleonCritter() {
    }

    public void processActors(ArrayList<Actor> actors) {
        int n = actors.size();
        if(n != 0) {
            int r = (int)(Math.random() * (double)n);
            Actor other = (Actor)actors.get(r);
            this.setColor(other.getColor());
        }
    }

    public void makeMove(Location loc) {
        this.setDirection(this.getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
}
