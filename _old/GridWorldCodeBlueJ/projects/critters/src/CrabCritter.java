import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;
import java.awt.*;

public class CrabCritter extends Critter {
    public CrabCritter() {
        this.setColor(Color.RED);
    }

    public ArrayList<Actor> getActors() {
        ArrayList actors = new ArrayList();
        int[] dirs = new int[]{0, -45, 45};
        Iterator i$ = this.getLocationsInDirections(dirs).iterator();

        while(i$.hasNext()) {
            Location loc = (Location)i$.next();
            Actor a = (Actor)this.getGrid().get(loc);
            if(a != null) {
                actors.add(a);
            }
        }

        return actors;
    }

    public ArrayList<Location> getMoveLocations() {
        ArrayList locs = new ArrayList();
        int[] dirs = new int[]{-90, 90};
        Iterator i$ = this.getLocationsInDirections(dirs).iterator();

        while(i$.hasNext()) {
            Location loc = (Location)i$.next();
            if(this.getGrid().get(loc) == null) {
                locs.add(loc);
            }
        }

        return locs;
    }

    public void makeMove(Location loc) {
        if(loc.equals(this.getLocation())) {
            double r = Math.random();
            byte angle;
            if(r < 0.5D) {
                angle = -90;
            } else {
                angle = 90;
            }

            this.setDirection(this.getDirection() + angle);
        } else {
            super.makeMove(loc);
        }

    }

    public ArrayList<Location> getLocationsInDirections(int[] directions) {
        ArrayList locs = new ArrayList();
        Grid gr = this.getGrid();
        Location loc = this.getLocation();
        int[] arr$ = directions;
        int len$ = directions.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            int d = arr$[i$];
            Location neighborLoc = loc.getAdjacentLocation(this.getDirection() + d);
            if(gr.isValid(neighborLoc)) {
                locs.add(neighborLoc);
            }
        }

        return locs;
    }
}
