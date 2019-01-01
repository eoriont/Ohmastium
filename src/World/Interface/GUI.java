package World.Interface;

import World.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI {

    public Vector pos, size;
    public boolean shown = false;

    public static List<GUI> guis = new ArrayList<>();

    public GUI() {
        guis.add(this);
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
