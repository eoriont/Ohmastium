package World.Blocks;

import World.Block.Block;
import World.Vector;
import World.WorldState;

import java.awt.*;

public class BlockGrass extends Block {
    public BlockGrass(Vector pos) {
        super(pos);
    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.setColor(Color.decode("#54ff26"));
        g.fillRect((int)(WorldState.cam.pos.x + (pos.x)),(int)(WorldState.cam.pos.y + (pos.y)), blockSize, blockSize);
    }

    public boolean isSolid() {
        return true;
    }
}
