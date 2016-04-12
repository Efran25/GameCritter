import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.*;

public class FlowerNode
{
    private Location myLocation;
    private FlowerNode next;

    FlowerNode head;
    FlowerNode current;
    FlowerNode n;

    public int life;

    //private Node previous; // used for double LinkedLists
    FlowerNode()
    {
        myLocation = new Location(0,0);
        next = null;
    }

    FlowerNode(Location loc)
    {
        myLocation = new Location(loc.getRow(), loc.getCol());
        next = null;
    }

    FlowerNode(Location loc, int life)
    {
        myLocation = new Location(loc.getRow(), loc.getCol());
        next = null;
        this.life = life;
    }

    FlowerNode(ArrayList<Location> a)
    {
        head = new FlowerNode(a.get(0));
        for (int i = 1; i < a.size(); i++)
        {
            n = new FlowerNode(a.get(i));
            for (current = head; current.getNext()!= null; current = current.getNext())
            {
                //empty
            }
            current.setNext(n);
        }

    }
    public Location getLocation()
    {
        return myLocation;
    }
    public FlowerNode getNext()
    {
        return next;
    }
    public void setNext(FlowerNode m)
    {
        next = m;
    }
}