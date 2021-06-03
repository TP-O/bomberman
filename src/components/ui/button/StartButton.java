package components.ui.button;

import asset.Asset;
import core.Router;

public class StartButton extends Button {

    public StartButton(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 158;
        height = 48;
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui01").crop(48, 73, 80, 25));
        frames.add(Asset.get("ui02").crop(80, 123, 132, 39));

        currentFrame = frames.get(0);
    }

    @Override
    public void onClick() {
        Router.getInstance().redirect("Game", true);
    }
}
