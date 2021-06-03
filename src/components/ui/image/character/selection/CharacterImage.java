package components.ui.image.character.selection;

import asset.Asset;
import components.ui.image.Image;

public class CharacterImage extends Image {

    public CharacterImage(int column, int row, int left, int right, int top, int bottom) {
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
        width = 475;
        height = 318;
    }

    @Override
    protected void loadAllFrames() {
        currentFrame = Asset.get("goku-background").crop(0, 0, 1920, 1080);
    }
}
