package components.ui.radio.character.selection;

import asset.Asset;

public class SatoshiRadio extends CharacterSelectionRadio {

    public SatoshiRadio(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);
    }

    @Override
    protected void setElementParameters() {
        width = 100;
        height = 100;
        value = "Satoshi";
    }

    @Override
    protected void loadAllFrames() {
        frames.add(Asset.get("ui03").crop(6, 50, 38, 38));
        frames.add(Asset.get("ui03").crop(190, 50, 38, 38));

        innerImage = Asset.get("satoshi-background").crop(0, 0, 603, 532);
        characterImage = Asset.get("satoshi-avatar").crop(0, 0, 548, 447);

        currentFrame = frames.get(0);
    }
}
