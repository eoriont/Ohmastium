package World.Interface;

import World.Vector;

import java.awt.*;

public class Interface {

    public Vector pos, size;
    public boolean shown = false;

    public Interface() {

    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {

    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public void setSize(Vector size) {
        this.size = size;
    }

    public void toggleShow() {
        this.shown = !this.shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }
}
