import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class CrabRunner {
    public CrabRunner() {
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7, 5), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(5, 7), new Rock());
        world.add(new Location(7, 3), new Rock());
        world.add(new Location(7, 8), new Flower());
        world.add(new Location(2, 2), new Flower());
        world.add(new Location(3, 5), new Flower());
        world.add(new Location(3, 8), new Flower());
        world.add(new Location(6, 5), new Bug());
        world.add(new Location(5, 3), new Bug());
        world.add(new Location(4, 5), new CrabCritter());
        world.add(new Location(6, 1), new CrabCritter());
        world.add(new Location(7, 4), new CrabCritter());
        world.show();
    }
}
