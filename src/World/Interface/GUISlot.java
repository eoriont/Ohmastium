package World.Interface;

import Assets.Assets;
import World.Vector;

import java.awt.*;

public class GUISlot {

    public Vector pos, size;

    public GUISlot(Vector pos, Vector size) {
        this.pos = pos;
        this.size = size;
    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.GUISLOT,(int) pos.x,(int) pos.y, (int)size.x, (int)size.y, null);
    }

}
