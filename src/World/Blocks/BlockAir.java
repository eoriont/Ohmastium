package World.Blocks;

import Assets.Assets;
import World.Block.Block;
import World.Vector;
import World.WorldState;

import java.awt.*;

public class BlockAir extends Block {


    public BlockAir(Vector pos) {
        super(pos);
    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.AIR, (int)(WorldState.cam.pos.x + (pos.x))-1,(int)(WorldState.cam.pos.y + (pos.y))-1, blockSize+1, blockSize+1, null);
    }

    public boolean isSolid() {
        return false;
    }
}
