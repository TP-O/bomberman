package core.service.keyboard;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import core.service.Service;
import core.game.Game;
import helper.Helper;

public class KeyService implements KeyListener, Service
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

    public int keyUp, keyDown, keyLeft, keyRight;

    public KeyService()
    {
        up = new Key();
        down = new Key();
        left = new Key();
        right = new Key();

        keyUp = Integer.parseInt(Helper.config("Key.Up"));
        keyDown = Integer.parseInt(Helper.config("Key.Down"));
        keyLeft = Integer.parseInt(Helper.config("Key.Left"));
        keyRight = Integer.parseInt(Helper.config("Key.Right"));
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
        if (keyCode == keyUp) {
            up.toggle(isPressed);
        }
        if (keyCode == keyDown) {
            down.toggle(isPressed);
        }
        if (keyCode == keyLeft) {
            left.toggle(isPressed);
        }
        if (keyCode == keyRight) {
            right.toggle(isPressed);
        }
    }

    public void register(Game game)
    {
        game.getWindow().getFrame().addKeyListener(this);
    }
}
