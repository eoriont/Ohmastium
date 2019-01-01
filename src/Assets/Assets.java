package Assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {

    public static BufferedImage getAssetImage(String path) {
        BufferedImage img = null;
        File imgfile = new File("assets/" + path + ".png");
        try {
            img = ImageIO.read(imgfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    public static BufferedImage GRASS, DIRT, AIR, PLAYER;
    public static BufferedImage FUSOR, GUI, GUIBUTTON, GUISLOT;
    public static BufferedImage CURSOR;

    public static void init() {
        GRASS = getAssetImage("grass");
        DIRT = getAssetImage("dirt");
        AIR = getAssetImage("air");
        PLAYER = getAssetImage("player");
        FUSOR = getAssetImage("fusor");
        CURSOR = getAssetImage("cursor");
        GUI = getAssetImage("GUI");
        GUIBUTTON = getAssetImage("guibutton");
        GUISLOT = getAssetImage("guislot");
    }
}
