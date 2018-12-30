package World;

import World.Block.Block;
import World.Blocks.BlockAir;
import World.Blocks.BlockGrass;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class World {

    public int w, h;
    public Map<Vector, Block> blockMap;

    public World(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public void init() {
        blockMap = new HashMap<Vector, Block>();

        for (int i = 0; i < this.w; i++) {
            for (int j = 0; j < this.h; j++) {
                Vector pos = new Vector(i, j);
                Vector rPos = pos.mult(Block.blockSize);
                if (pos.y < this.w/2) {
                    blockMap.put(rPos, new BlockAir(rPos));
                }
                if (pos.y >= this.w/2) {
                    blockMap.put(rPos, new BlockGrass(rPos));
                }
            }
        }
    }

    public void tick(double deltaTime) {
        for (Block b : blockMap.values()) {
            b.tick(deltaTime);
        }
    }

    public void render(Graphics2D g) {
        for (Block b : blockMap.values()) {
            b.render(g);
        }
    }

}
