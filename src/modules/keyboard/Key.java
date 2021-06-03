package modules.keyboard;

public class Key {

    private boolean pressed;

    public Key() {
        pressed = false;
    }

    public void toggle(boolean isPressed) {
        pressed = isPressed;
    }

    public boolean isPressed() {
        return pressed;
    }
}
