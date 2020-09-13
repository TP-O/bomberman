package core.service.keyboard;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyManager implements KeyListener
{
    public class Key
    {
        public boolean pressed = false;

        public void toggle(boolean isPressed)
        {
            pressed = isPressed;
        }
    }

    public Key up, down, left, right;

    public KeyManager()
    {
        up = new Key();
        down = new Key();
        left = new Key();
        right = new Key();
    }

    public void keyPressed(KeyEvent event)
    {
        toggleKey(event.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent event)
    {
        toggleKey(event.getKeyCode(), false);
    }

    public void keyTyped(KeyEvent event)
    {
        //
    }

    public void toggleKey(int keyCode, boolean isPressed)
    {
        if (keyCode == KeyEvent.VK_W) up.toggle(isPressed);
        if (keyCode == KeyEvent.VK_S) down.toggle(isPressed);
        if (keyCode == KeyEvent.VK_A) left.toggle(isPressed);
        if (keyCode == KeyEvent.VK_D) right.toggle(isPressed);
    }
}
