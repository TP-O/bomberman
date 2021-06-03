package components.ui.button;

import asset.Asset;

public class QuitButton extends Button {

    public QuitButton(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 158;
        height = 48;
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui01").crop(145, 250, 82, 25));
        frames.add(Asset.get("ui02").crop(243, 416, 132, 41));

        currentFrame = frames.get(0);
    }

    @Override
    public void onClick() {
        System.exit(0);
    }
}
