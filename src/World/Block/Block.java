package World.Block;


import World.Vector;
import World.WorldState;

import java.awt.*;

public class Block {

    public final static int blockSize = 50;

    public Vector pos;

    public Block(Vector pos) {
        this.pos = pos;
    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void mouseClick(Vector mousePos) {

    }

    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawRect((int)(WorldState.cam.pos.x + (pos.x)),(int)(WorldState.cam.pos.y + (pos.y)), blockSize, blockSize);
    }

    public boolean isSolid() {
        return false;
    }

}

