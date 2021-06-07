package components.ui.image.character.selection;

import config.GameConfig;
import asset.Asset;
import components.ui.image.Image;

public class CharacterBackground extends Image {

    public CharacterBackground(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    public void onHover() {
        //
    }

    @Override
    public void onClick() {
        //
    }

    @Override
    public void onWaiting() {
        //
    }

    @Override
    protected void setElementParameters() {
        width = GameConfig.WIDTH;
        height = GameConfig.HEIGHT;
    }

    @Override
    protected void loadAllFrames() {
        currentFrame = Asset.get("bg01").crop(0, 0, 1000, 760);
    }
}
