package World.Blocks;

import Assets.Assets;
import World.Block.Block;
import World.Interfaces.FusorInterface;
import World.Vector;
import World.WorldState;

import java.awt.*;

public class BlockFusor extends Block {

    public FusorInterface fusorInterface;

    public BlockFusor(Vector pos) {
        super(pos);
    }

    public void init() {
        fusorInterface = new FusorInterface();
    }

    public void tick(double deltaTime) {

    }

    @Override
    public void mouseClick(Vector mousePos) {
        super.mouseClick(mousePos);
        System.out.println("clicked4");
        fusorInterface.toggleShow();
    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.FUSOR, (int)(WorldState.cam.pos.x + (pos.x)),(int)(WorldState.cam.pos.y + (pos.y)), blockSize, blockSize, null);
        fusorInterface.render(g);
    }

    public boolean isSolid() {
        return true;
    }
}
