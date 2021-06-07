package components.ui.button;

import asset.Asset;
import core.Router;

public class PlayButton extends Button {

    public PlayButton(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 148;
        height = 48;
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui01").crop(47, 108, 82, 24));
        frames.add(Asset.get("ui02").crop(80, 182, 133, 40));

        currentFrame = frames.get(0);
    }

    @Override
    public void onClick() {
        Router.getInstance().redirect("Character", false);
    }
}
