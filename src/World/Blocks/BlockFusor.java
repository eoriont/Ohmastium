package World.Blocks;

import Assets.Assets;
import World.Block.Block;
import World.Interfaces.FusorGUI;
import World.Vector;
import World.WorldState;

import java.awt.*;

public class BlockFusor extends Block {

    public FusorGUI fusorInterface;

    public BlockFusor(Vector pos) {
        super(pos);
    }

    public void init() {
        fusorInterface = new FusorGUI();
    }

    public void tick(double deltaTime) {

    }

    @Override
    public void mouseClick(Vector mousePos) {
        super.mouseClick(mousePos);
        fusorInterface.toggleShow();
    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.FUSOR, (int)(WorldState.cam.pos.x + (pos.x))-1,(int)(WorldState.cam.pos.y + (pos.y))-1, blockSize+1, blockSize+1, null);
//        fusorInterface.render(g);
    }

    public boolean isSolid() {
        return true;
    }
}
