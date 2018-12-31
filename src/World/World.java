package World;

import Input.MouseManager;
import World.Block.Block;
import World.Blocks.BlockAir;
import World.Blocks.BlockDirt;
import World.Blocks.BlockFusor;
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
        Vector fusorPos = new Vector(10, 9).mult(Block.blockSize);
        for (int i = 0; i < this.w; i++) {
            for (int j = 0; j < this.h; j++) {
                Vector pos = new Vector(i, j);
                Vector rPos = pos.mult(Block.blockSize);
                if (i == 10 && j == 9) {
                    blockMap.put(fusorPos, new BlockFusor(fusorPos));
                    continue;
                }

                if (pos.x == 0 || pos.x == this.w-1) {
                    blockMap.put(rPos, new BlockDirt(rPos));
                    continue;
                }

                if (pos.y < this.w/2) {
                    blockMap.put(rPos, new BlockAir(rPos));
                } else if (pos.y == this.w/2) {
                    blockMap.put(rPos, new BlockGrass(rPos));
                } else if (pos.y > this.w/2) {
                    blockMap.put(rPos, new BlockDirt(rPos));
                }
            }
        }

        for (Block b : blockMap.values()) {
            b.init();
        }
    }

    public void tick(double deltaTime) {
        for (Block b : blockMap.values()) {
            b.tick(deltaTime);
        }
    }

    public void mouseClick(Vector mousePos) {
        for (Block b : blockMap.values()) {
            Vector mPos = mousePos.subtract(WorldState.cam.pos);
            if (Vector.collision(mPos, new Vector(10, 10), b.pos, new Vector(Block.blockSize))) {
                System.out.println(b.pos);
                b.mouseClick(mousePos);
                break;
            }
        }
    }

    public void render(Graphics2D g) {
        for (Block b : blockMap.values()) {
            b.render(g);
        }
    }

}
