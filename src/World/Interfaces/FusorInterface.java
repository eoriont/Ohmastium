package World.Interfaces;

import World.Interface.Interface;
import World.Vector;

import java.awt.*;

public class FusorInterface extends Interface {

    public FusorInterface() {
        setPos(new Vector(20, 20));
        setSize(new Vector(100, 100));
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void tick(double deltaTime) {
        super.tick(deltaTime);
    }

    @Override
    public void render(Graphics2D g) {
        if (!shown) return;
        super.render(g);
        g.setColor(Color.WHITE);
        g.fillRect((int)pos.x, (int)pos.y, (int)size.x, (int)size.y);
    }
}
