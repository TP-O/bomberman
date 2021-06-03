package components.ui.button;

import asset.Asset;
import core.Router;

public class PauseButton extends Button {

    public PauseButton(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 74;
        height = 24;
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui01").crop(48, 144, 80, 24));
        frames.add(Asset.get("ui02").crop(78, 236, 140, 48));

        currentFrame = frames.get(0);
    }

    @Override
    public void onClick() {
        Router.getInstance().redirect("PauseMenu", false);
    }
}
