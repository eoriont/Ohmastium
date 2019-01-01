package World.Interfaces;

import Assets.Assets;
import Game.Constants;
import World.Interface.GUI;
import World.Interface.GUIButton;
import World.Interface.GUISlot;
import World.Vector;

import java.awt.*;

public class FusorGUI extends GUI {

    public GUIButton fuseButton;
    public GUISlot inSlot1, inSlot2, outSlot;

    public FusorGUI() {
        setPos(new Vector(Constants.getScreenSize().x*0.2f, Constants.getScreenSize().y*0.2f));
        setSize(new Vector(Constants.getScreenSize().x*0.6f, Constants.getScreenSize().y*0.6f));
    }

    @Override
    public void init() {
        super.init();
        fuseButton = new GUIButton("Fuse", new Vector(700, 800),
                                   new Vector(100, 100));

        inSlot1 = new GUISlot(new Vector(700, 500),
                new Vector(100, 100));
        inSlot2 = new GUISlot(new Vector(900, 500),
                new Vector(100, 100));
        outSlot = new GUISlot(new Vector(1100, 500),
                new Vector(100, 100));
    }

    @Override
    public void tick(double deltaTime) {
        super.tick(deltaTime);
        fuseButton.tick(deltaTime);
        inSlot1.tick(deltaTime);
        inSlot2.tick(deltaTime);
        outSlot.tick(deltaTime);
    }

    @Override
    public void render(Graphics2D g) {
        if (!shown) return;
        super.render(g);
        g.drawImage(Assets.GUI, (int)pos.x, (int)pos.y, (int)size.x, (int)size.y, null);
        fuseButton.render(g);
        inSlot1.render(g);
        inSlot2.render(g);
        outSlot.render(g);
    }
}
