package components.ui.button;

import asset.Asset;
import core.Router;

public class ReturnButton extends Button {

    public ReturnButton(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 148;
        height = 38;
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui01").crop(47, 249, 81, 25));
        frames.add(Asset.get("ui02").crop(81, 417, 132, 40));

        currentFrame = frames.get(0);
    }

    @Override
    public void onClick() {
        Router.getInstance().redirect("Menu", false);
    }
}
