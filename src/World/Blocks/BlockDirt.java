package World.Blocks;

import Assets.Assets;
import World.Block.Block;
import World.Vector;
import World.WorldState;

import java.awt.*;

public class BlockDirt extends Block {
    public BlockDirt(Vector pos) {
        super(pos);
    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.DIRT, (int)(WorldState.cam.pos.x + (pos.x)),(int)(WorldState.cam.pos.y + (pos.y)), blockSize, blockSize, null);
    }

    public boolean isSolid() {
        return true;
    }
}
