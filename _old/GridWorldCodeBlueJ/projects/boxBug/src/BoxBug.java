
import info.gridworld.actor.*;

public class BoxBug extends Bug {
    private int steps = 0;
    private int sideLength;

    public BoxBug(int length) {
        this.sideLength = length;
    }

    public void act() {
        if(this.steps < this.sideLength && this.canMove()) {
            this.move();
            ++this.steps;
        } else {
            this.turn();
            this.turn();
            this.steps = 0;
        }

    }
}
