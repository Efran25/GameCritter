/**
 * Created by ehimel16 on 4/11/2016.
 */
import info.gridworld.actor.*;
import java.awt.Color;
import java.util.*;

public class RedFlower extends Flower
{
    public int life = ((int) ((Math.random() * 10) + 5));

    public RedFlower()
    {
        setColor(Color.RED);
    }

    public void act()
    {
        if (life > 0)
        {
            life--;
            darken();
        }
        else
        {
            removeSelfFromGrid();
        }
    }

    public int getFlowerLife() {
        return life;
    }
    private void darken(){
        double DARKENING_FACTOR = 0.10;

        Color c = getColor();

        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    }

}