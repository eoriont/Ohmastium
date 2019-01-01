package World.Interface;

import Assets.Assets;
import World.Vector;

import java.awt.*;

public class GUIButton {

    public Vector pos, size;
    public String text;

    public GUIButton(String text, Vector pos, Vector size) {
        this.text = text;
        this.pos = pos;
        this.size = size;
    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.GUIBUTTON,(int) pos.x,(int) pos.y, (int)size.x, (int)size.y, null);
        g.drawString(text,pos.x+(size.x/2),pos.y+(size.y/2));
    }

}
