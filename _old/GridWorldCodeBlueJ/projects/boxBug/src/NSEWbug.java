import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;

/**
 * Created by Efran25 on 3/21/2016.
 */
public class NSEWbug extends Bug{
    public NSEWbug() {
        setColor(Color.BLUE);
        int turn = 90 * ((int)((Math.random() * 4) + 1));
        setDirection(turn);
    }
    public void act() {
        if (canMove())
            move();
        else
            turn();
    }
    public void turn() {
        int current = getDirection();
        int turn = 90 * ((int)((Math.random() * 4) + 1));
        while(turn != current) {
            setDirection(turn);
            break;
        }
    }
}
