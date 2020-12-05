package core.service.keyboard;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import core.service.Service;
import app.controller.GameController;
import helper.Helper;

public class KeyService implements KeyListener, Service
{
    public class Key
    {
        private boolean pressed;

        public Key()
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

    public Key up, down, left, right, attack;

    private int keyUp, keyDown, keyLeft, keyRight, keyAttack;

    public KeyService()
    {
        up = new Key();
        down = new Key();
        left = new Key();
        right = new Key();
        attack = new Key();

        keyUp = Helper.config("Key.Up");
        keyDown = Helper.config("Key.Down");
        keyLeft = Helper.config("Key.Left");
        keyRight = Helper.config("Key.Right");
        keyAttack = KeyEvent.VK_ENTER;
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
        if (keyCode == keyAttack) {
            attack.toggle(isPressed);
        }
    }

    public void register(GameController game)
    {
        game.getWindow().getFrame().addKeyListener(this);
    }
}
