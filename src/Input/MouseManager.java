package Input;

import Engine.GameLoop;
import World.Vector;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    public static Vector pos;

    public static Vector getPos() {
        return pos;
    }


    private GameLoop gl;

    public MouseManager(GameLoop gl) {
        this.gl = gl;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gl.gsm.mouseClick(new Vector(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        pos = new Vector(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pos = new Vector(e.getX(), e.getY());
    }
}
