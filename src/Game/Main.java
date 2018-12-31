package Game;

import Assets.Assets;
import Engine.GameLoop;
import Engine.GameWindow;
import Input.KeyboardManager;
import Input.MouseManager;

import java.awt.*;

public class Main {

    public static GameWindow frame;

    public static void main(String[] args) {
        Constants.init();
        Assets.init();
        frame = new GameWindow("Ohmastium", (int) Constants.getScreenSize().x, (int) Constants.getScreenSize().y);
        GameLoop gameLoop = new GameLoop((int) Constants.getScreenSize().x, (int) Constants.getScreenSize().y);
        frame.setFullscreen(1);

        KeyboardManager km = new KeyboardManager();
        frame.addKeyListener(km);

        MouseManager mm = new MouseManager(gameLoop);
        frame.addMouseListener(mm);
        frame.addMouseMotionListener(mm);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor cursor = toolkit.createCustomCursor(Assets.CURSOR, new Point(0, 0), "Cursor");

        frame.setCursor(cursor);
        frame.add(gameLoop);
        frame.setVisible(true);

    }

}
