package core.service.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import app.controller.GameController;
import core.service.Service;

public class MouseService implements Service, MouseListener, MouseMotionListener
{
    public class Mouse
    {
        private boolean pressed;

        public Mouse()
        {
            pressed = false;
        }

        public void toggle(boolean isPressed)
        {
            pressed = isPressed;
        }

        public boolean isPressed()
        {
            return pressed;
        }
    }

    public int mouseX, mouseY;

    public Mouse left, right;

    private int mouseLeft, mouseRight;

    public MouseService()
    {
        left = new Mouse();
        right = new Mouse();

        mouseLeft = MouseEvent.BUTTON1;
        mouseRight = MouseEvent.BUTTON3;
    }

    @Override
    public void mouseDragged(MouseEvent event)
    {
        //
    }

    @Override
    public void mouseMoved(MouseEvent event)
    {
        mouseX = event.getX();
        mouseY = event.getY();
    }

    @Override
    public void mouseClicked(MouseEvent event)
    {

    }

    @Override
    public void mousePressed(MouseEvent event)
    {
        toggle(event.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent event)
    {
        toggle(event.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent event)
    {
        //
    }

    @Override
    public void mouseExited(MouseEvent event)
    {
        //
    }

    public void toggle(int mouseButton, boolean isPressed)
    {
        if (mouseButton == mouseLeft) {
            left.toggle(isPressed);
        }
        else if (mouseButton == mouseRight) {
            right.toggle(isPressed);
        }
    }

    public void register(GameController gameController)
    {
        gameController.getWindow().getFrame().addMouseListener(this);
        gameController.getWindow().getFrame().addMouseMotionListener(this);
        gameController.getWindow().getCanvas().addMouseListener(this);
        gameController.getWindow().getCanvas().addMouseMotionListener(this);
    }
}
