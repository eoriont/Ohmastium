package World.Blocks;

import World.Block.Block;
import World.Vector;

import java.awt.*;

public class BlockAir extends Block {


    public BlockAir(Vector pos) {
        super(pos);
    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        super.render(g);
    }

    public boolean isSolid() {
        return false;
    }
}
