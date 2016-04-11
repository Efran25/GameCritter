import com.sun.org.apache.bcel.internal.classfile.AccessFlags;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.*;
import java.awt.*;

/**
 * Created by Efran25 on 3/31/2016.
 */
public class RedBase extends Rock {
    public ArrayList<Flower> flowerList = new ArrayList<Flower>();
    private ActorWorld world = new ActorWorld();
//Constructor
    public RedBase() {setColor(Color.red);
    }

    public RedBase(ActorWorld gameWorld) {
        setColor(Color.red);
        world = gameWorld;
        world.add(new Location(0, 9), new RedNodeCritter());

    }

    public RedBase(ArrayList<Flower> fl, ActorWorld gameWorld) {
        setColor(Color.red);
        flowerList = fl;
        world = gameWorld;
        world.add(new Location(0, 4), new RedNodeCritter());
    }

//Main
    public void act() {
        if (checkEmpty()) {
            if(flowerList.size() == 0)
            makeFlowers();

            System.out.println(flowerList.size());

            for (int TrangTrang = 0; TrangTrang < flowerList.size(); TrangTrang++) {
                Location randomLoc = new Location((((int) (Math.random() * 9) + 0)), (((int) (Math.random() * 9) + 0)));
                while (getGrid().get(randomLoc) instanceof Actor) {
                    randomLoc = new Location((((int) (Math.random() * 9) + 0)), (((int) (Math.random() * 9) + 0)));
                }

                flowerList.get(TrangTrang).putSelfInGrid(getGrid(), randomLoc);
            }

                flowerList.clear();
        }
    }
    // Helper
    public boolean checkEmpty() {
        for (Location a : getGrid().getOccupiedLocations()) {
            if (getGrid().get(a) instanceof Flower)
                return false;
        }
        for(Actor b: getGrid().getNeighbors(getLocation())) {
            if (b instanceof RedNodeCritter)
            return true;
        }
    return false;
    }

    public void makeFlowers() {
        int max = ((int) ((Math.random() * 8) + 4));
        //System.out.println(max);

        for (int i = 0; i < max; i++) {
            RedFlower fl = new RedFlower();
            flowerList.add(fl);
        }

    }
}

