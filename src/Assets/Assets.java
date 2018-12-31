package Assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {

    public BufferedImage getAssetImage(String path) {
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

    public void init() {
        GRASS = getAssetImage("grass");
        DIRT = getAssetImage("dirt");
        AIR = getAssetImage("air");
        PLAYER = getAssetImage("player");
    }
}
