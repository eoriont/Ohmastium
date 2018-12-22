package Game;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {

    public Stack<GameState> gameStates;

    public GameStateManager() {
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

}
