package components.ui.radio.character.selection;

import asset.Asset;
import core.Handler;

public class GokuRadio extends CharacterSelectionRadio
{
    public GokuRadio(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }

    @Override
    protected void loadInfo()
    {
        width = 100;
        height = 100;
        value = "Goku";
    }

    @Override
    protected void loadImages()
    {
        images.add(Asset.ui03.crop(6, 50, 38, 38));
        images.add(Asset.ui03.crop(190, 50, 38, 38));
        innerImage = Asset.gokuAvatar.crop(0, 0, 121, 145);
        characterImage = Asset.gokuBackground.crop(0, 0, 1920, 1080);

        currentImage = images.get(0);
    }
}
