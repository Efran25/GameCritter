import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class ChameleonRunner {
    public ChameleonRunner() {
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Rock());
        //world.add(new Critter());
        /*
        world.add(new Location(7, 8), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(2, 8), new Rock(Color.BLUE));
        world.add(new Location(5, 5), new Rock(Color.PINK));
        world.add(new Location(1, 5), new Rock(Color.RED));
        world.add(new Location(7, 2), new Rock(Color.YELLOW));
        world.add(new Location(4, 4), new ChameleonCritter());
        world.add(new Location(5, 8), new ChameleonCritter());
        */

        //world.add(new Location(4, 4), new BullyCritter());

        //world.add(new Location(4, 4), new CrossCritter());

        world.add(new Location(6, 6), new DiagonalCritter());
        world.add(new Location(7, 7), new Rock());
        world.add(new Location(7, 6), new Rock());
        world.add(new Location(7, 5), new Rock());
        world.add(new Location(6, 7), new Rock());
        world.add(new Location(6, 5), new Rock());
        world.add(new Location(5, 7), new Rock());
        world.add(new Location(5, 6), new Rock());
        world.add(new Location(5, 5), new Rock());

        world.show();
    }
}
