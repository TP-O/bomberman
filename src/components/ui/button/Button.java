package components.ui.button;

import components.ui.Element;

public abstract class Button extends Element {

    public Button(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    public void onWaiting() {
        currentFrame = frames.get(0);
    }

    @Override
    public void onHover() {
        currentFrame = frames.get(1);
    }
}
