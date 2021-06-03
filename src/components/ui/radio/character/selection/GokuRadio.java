package components.ui.radio.character.selection;

import asset.Asset;

public class GokuRadio extends CharacterSelectionRadio {

    public GokuRadio(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 100;
        height = 100;
        value = "Goku";
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui03").crop(6, 50, 38, 38));
        frames.add(Asset.get("ui03").crop(190, 50, 38, 38));

        innerImage = Asset.get("goku-avatar").crop(0, 0, 121, 145);
        characterImage = Asset.get("goku-background").crop(0, 0, 1920, 1080);

        currentFrame = frames.get(0);
    }
}
