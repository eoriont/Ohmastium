package Camera;

import Game.Constants;
import Player.Player;
import World.Vector;

import java.awt.*;

public class Camera {

    public Vector pos;

    public Camera(Vector pos) {
        this.pos = pos;
    }

    public void init() {

    }

    public void tick(double deltaTime) {

    }

    public void render(Graphics2D g) {

    }

    public void followPlayer(Player p) {
        this.pos = new Vector((int) (Constants.getScreenSize().x/2 - p.size.x/2) - (p.pos.x), (int) (Constants.getScreenSize().y/2 - p.size.y/2) - (p.pos.y));
    }

}
