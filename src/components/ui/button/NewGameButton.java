package components.ui.button;

import asset.Asset;
import core.Router;

public class NewGameButton extends Button {

    public NewGameButton(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 178;
        height = 48;
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui01").crop(243, 73, 118, 26));
        frames.add(Asset.get("ui02").crop(403, 120, 202, 43));

        currentFrame = frames.get(0);
    }

    @Override
    public void onClick() {
        Router.getInstance().redirect("Game", true);
    }
}
