package Player;

import Assets.Assets;
import Camera.*;
import Game.GameStateManager;
import Input.KeyboardManager;
import World.Block.Block;
import World.Vector;
import World.World;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public Vector pos;
    public World world;
    public Camera cam;
    public GameStateManager gsm;

    public float moveSpeed = 2;

    public Vector vel, accel;

    public boolean grounded = false;

    public Vector size;

    public Player(GameStateManager gsm, World world, Camera cam) {
        this.gsm = gsm;
        this.world = world;
        this.cam = cam;
    }

    public void init() {
        pos = new Vector(0, 0);
        size = new Vector(50, 50);
        vel = new Vector(0, 0);
        accel = new Vector(0, .2f);
    }

    public void tick(double deltaTime) {
        if (KeyboardManager.isKeyDown(KeyEvent.VK_SPACE) && grounded) {
            this.vel.y -= 10;
        }

        this.vel.y += this.accel.y;
        this.pos.y += this.vel.y;
        boolean isCol = false;
        for (Block b : world.blockMap.values()) {
            if (b.isSolid()) {
                boolean col = Vector.collision(pos, size, b.pos, new Vector(Block.blockSize));
                if (col) {
                    isCol = true;
                    if (vel.y > 0) {
                        this.pos.y = b.pos.y-size.y;
                        this.vel.y = 0;
                        grounded = true;
                    } else if (vel.y <= 0) {
                        this.pos.y = b.pos.y+Block.blockSize;
                        this.vel.y = 0;
                        grounded = true;
                    }
                    break;
                }
            }
        }
        if (!isCol) {
            grounded = false;
        }

        if (KeyboardManager.isKeyDown(KeyEvent.VK_A)) {
            this.pos.x -= moveSpeed;
            for (Block b : world.blockMap.values()) {
                if (b.isSolid()) {
                    boolean col = Vector.collision(pos, size, b.pos, new Vector(Block.blockSize));
                    if (col) {
                        this.pos.x += moveSpeed;
                        break;
                    }
                }
            }
        }
        if (KeyboardManager.isKeyDown(KeyEvent.VK_D)) {
            this.pos.x += moveSpeed;
            for (Block b : world.blockMap.values()) {
                if (b.isSolid()) {
                    boolean col = Vector.collision(pos, size, b.pos, new Vector(Block.blockSize));
                    if (col) {
                        this.pos.x -= moveSpeed;
                        break;
                    }
                }
            }
        }
        if (KeyboardManager.isKeyDown(KeyEvent.VK_ESCAPE)) {
            System.out.println("Exiting...");
            System.exit(1);
        }
    }

    public void render(Graphics2D g) {
        g.drawImage(Assets.PLAYER, (int)(cam.pos.x + pos.x), (int)(cam.pos.y + pos.y), (int) size.x, (int) size.y, null);
    }

}
