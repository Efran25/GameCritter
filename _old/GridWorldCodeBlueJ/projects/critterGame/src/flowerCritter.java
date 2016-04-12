import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mqureshi16 on 3/24/2016.
 */
public class flowerCritter extends Critter {
    ActorWorld world;
    public flowerCritter(ActorWorld world) {
        this.world = world;
    }

    public void act() {
        /*
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);*/
        move(new Location(7,4));
    }

    public void move(Location goal){
        ArrayList<Location> locs = new ArrayList<Location>();
        HashMap<Location,Integer> costs = new HashMap<Location,Integer>();
        for(Location next : getGrid().getValidAdjacentLocations(getLocation())){
            costs.put(next, distBetween(next,goal));
            locs.add(next);
        }
        Location s = locs.get(0);
        for(Location l : locs){
            if(costs.get(l) < costs.get(s)){
                s = l;
            }
        }
        if (s == null)
            removeSelfFromGrid();
        else
            setDirection(getLocation().getDirectionToward(s));
        moveTo(s);
    }

    /*
    Create a 'frontier'
    add ourselves to the frontier
    Create a visited set
    add our location as visitted
    while the frontier is not empty
    set current to the next location in frontier
    for each neighbor of our location check if visitted
    if not visitted put it in frontier
    and set it visitted
     *//*
    private Queue findPath(Location start, Location goal) {/*
        HashSet<Location> open = new HashSet<Location>();
        open.add(getLocation());
        Map<Location, Location> cameFrom = new HashMap<Location, Location>();
        cameFrom.put(start,null);
        Map<Location, Integer> cost = new HashMap<Location, Integer>();
        cost.put(start,0);
        while (!open.isEmpty()) {
            Location current = findSmallest(open, fScore);
            System.out.println("Current is: " + current);
            open.remove(current);
            closed.add(current);
            for (Location next : getGrid().getValidAdjacentLocations(current)) {
                System.out.println("Checking next: " + next);
                if (closed.contains(next))
                    continue;
                int tentativegScore = gScore.get(current) + distBetween(current, next);
                if (!(open.contains(next))) {
                    open.add(next);
                } else if (tentativegScore >= gScore.get(next)) {
                    continue;
                }
                cameFrom.put(next,current);
                gScore.put(next,tentativegScore);
                fScore.put(next,gScore.get(next) + distBetween(next,goal));
            }
        }
        Queue<Location> path = new LinkedList<Location>();
        Location current = start;
        while(cameFrom.containsKey(current)){
            path.add(cameFrom.get(current));
        }
        return path;
    }*/

    private int distBetween(Location a, Location b) {
        int h = 0;
        if(getGrid().get(a) instanceof Rock){
            h+=20;
        }
        if(getGrid().get(a) != null){
            h++;
        }
        return (Math.abs(a.getCol() - b.getCol()) + Math.abs(a.getRow() - b.getRow()) + h);
    }

}