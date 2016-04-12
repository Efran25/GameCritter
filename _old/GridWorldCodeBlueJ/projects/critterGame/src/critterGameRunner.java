/**
 * Created by Efran25 on 3/31/2016.
 */

import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.*;

public class critterGameRunner {
    public static void main(String args[])
    {
        ActorWorld world = new ActorWorld();

        world.add(new Location(0,0), new RedBase(world));

        world.show();
    }

    //fuck this shit, jk
}

