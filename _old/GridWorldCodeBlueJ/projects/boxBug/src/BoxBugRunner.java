import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;

public class BoxBugRunner {
    public BoxBugRunner() {
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Rock());
        //world.add(new Critter());

        /*
        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);
        BoxBug bob = new BoxBug(3);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        NSEWbug bob = new NSEWbug();
        world.add(new Location(5, 5), bob);
        FlowerBug bob = new FlowerBug();
        world.add(new Location(5, 5), bob);
        BattleBug bob = new BattleBug();
        world.add(new Location(5, 5), bob);
        WarpBug bob = new WarpBug();
        world.add(new Location(5, 5), bob);
        */

        PushAwayBug bob = new PushAwayBug();
        world.add(new Location(5, 5), bob);

        world.show();
    }
}