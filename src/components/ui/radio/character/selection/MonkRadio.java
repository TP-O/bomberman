package components.ui.radio.character.selection;

import asset.Asset;

public class MonkRadio extends CharacterSelectionRadio {

    public MonkRadio(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 100;
        height = 100;
        value = "Monk";
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui03").crop(6, 50, 38, 38));
        frames.add(Asset.get("ui03").crop(190, 50, 38, 38));

        innerImage = Asset.get("monk-avatar").crop(0, 0, 351, 350);
        characterImage = Asset.get("monk-avatar").crop(0, 0, 351, 350);

        currentFrame = frames.get(0);
    }
}
