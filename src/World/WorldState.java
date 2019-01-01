package World;

import Camera.*;
import Game.GameState;
import Game.GameStateManager;
import Player.Player;
import World.Interface.GUI;

import java.awt.*;

public class WorldState extends GameState {

    public World world;
    public Player player;
    public static Camera cam;

    public WorldState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        cam = new Camera(new Vector(0, 0));
        cam.init();

        world = new World(20, 20);
        world.init();

        player = new Player(gsm, world, cam);
        player.init();

        for (GUI gui : GUI.guis) {
            gui.init();
        }
    }

    @Override
    public void tick(double deltaTime) {
        cam.tick(deltaTime);
        cam.followPlayer(player);
        world.tick(deltaTime);
        player.tick(deltaTime);
        for (GUI gui : GUI.guis) {
            gui.tick(deltaTime);
        }
    }

    @Override
    public void render(Graphics2D g) {
        world.render(g);
        player.render(g);
        for (GUI gui : GUI.guis) {
            gui.render(g);
        }
    }

    @Override
    public void mouseClick(Vector mousePos) {
        world.mouseClick(mousePos);
    }


}
