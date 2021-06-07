package components.ui.radio.character.selection;

import asset.Asset;

public class KiritoRadio extends CharacterSelectionRadio {

    public KiritoRadio(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 100;
        height = 100;
        value = "Kirito";
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui03").crop(6, 50, 38, 38));
        frames.add(Asset.get("ui03").crop(190, 50, 38, 38));

        innerImage = Asset.get("kirito-background").crop(0, 0, 900, 794);
        characterImage = Asset.get("kirito-avatar").crop(0, 0, 576, 482);

        currentFrame = frames.get(0);
    }
}
