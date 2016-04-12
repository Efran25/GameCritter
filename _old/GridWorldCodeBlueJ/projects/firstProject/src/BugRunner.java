/**
 * Created by Efran25 on 3/19/2016.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import info.gridworld.actor.*;

public class BugRunner {
    public BugRunner() {
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Bug());
        world.add(new Rock());
        world.show();
    }
}
