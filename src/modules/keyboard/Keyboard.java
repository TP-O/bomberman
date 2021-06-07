package modules.keyboard;

import java.awt.event.KeyListener;

import modules.Module;

import java.awt.event.KeyEvent;

import config.KeyConfig;
import core.Handler;

public class Keyboard implements KeyListener, Module {

    public Key up, down, left, right, attack;

    private int keyUp, keyDown, keyLeft, keyRight, keyAttack;

    public Keyboard() {
        up = new Key();
        down = new Key();
        left = new Key();
        right = new Key();
        attack = new Key();

        keyUp = KeyConfig.UP;
        keyDown = KeyConfig.DOWN;
        keyLeft = KeyConfig.LEFT;
        keyRight = KeyConfig.RIGHT;
        keyAttack = KeyConfig.ATTACK;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        toggleKey(event.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        toggleKey(event.getKeyCode(), false);
    }

    @Override
    public void keyTyped(KeyEvent event) {
        //
    }

    public void toggleKey(int keyCode, boolean isPressed) {
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

    @Override
    public void register(Handler handler) {
        handler.getFrame().addKeyListener(this);
    }
}
