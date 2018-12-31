package Game;

import World.Vector;
import World.WorldState;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {

    public Stack<GameState> gameStates;

    public GameStateManager(Graphics2D g) {
        gameStates = new Stack<>();
        gameStates.push(new WorldState(this));
    }

    public void init() {
        gameStates.peek().init();
    }

    public void tick(double deltaTime) {
        gameStates.peek().tick(deltaTime);
    }

    public void render(Graphics2D g) {
        gameStates.peek().render(g);
    }

    public void mouseClick(Vector mousePos) {
        gameStates.peek().mouseClick(mousePos);
    }

}
