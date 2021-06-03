package modules.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modules.Module;
import core.Handler;

public class Mouse implements MouseListener, MouseMotionListener, Module {

    public int mouseX, mouseY;

    public Key left, right;

    private int mouseLeft, mouseRight;

    public Mouse() {
        left = new Key();
        right = new Key();

        mouseLeft = MouseEvent.BUTTON1;
        mouseRight = MouseEvent.BUTTON3;
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        //
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();
    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent event) {
        toggle(event.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        toggle(event.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        //
    }

    @Override
    public void mouseExited(MouseEvent event) {
        //
    }

    public void toggle(int mouseButton, boolean isPressed) {
        if (mouseButton == mouseLeft) {
            left.toggle(isPressed);
        } else if (mouseButton == mouseRight) {
            right.toggle(isPressed);
        }
    }

    @Override
    public void register(Handler handler) {
        handler.getFrame().addMouseListener(this);
        handler.getFrame().addMouseMotionListener(this);
        handler.getCanvas().addMouseListener(this);
        handler.getCanvas().addMouseMotionListener(this);
    }
}
