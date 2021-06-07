package components.ui.text;

import helper.Helper;
import java.awt.Graphics;

import components.ui.Element;

public abstract class Text extends Element {

    public Text(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);

        loadAllFrames();
    }

    @Override
    protected void loadAllFrames() {
        // Delete old frames
        frames.clear();

        // Transform to uppercase
        value = value.toUpperCase();

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != ' ') {
                frames.add(Helper.loadImage("alphabet/" + value.charAt(i) + ".png"));
            } else {
                frames.add(null);
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        // Calculate position x to make the text in the center
        int newX = x - (value.length() - 1) * width / 2;

        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i) == null) {
                continue;
            }

            graphics.drawImage(frames.get(i), newX + width * i, y, width, height, null);
        }
    }
}
