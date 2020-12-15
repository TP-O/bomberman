package components.ui.radio.character.selection;

import asset.Asset;
import core.Handler;

public class MonkRadio extends CharacterSelectionRadio
{
    public MonkRadio(Handler handler, int column, int row, int left, int right, int top, int bottom)
    {
        super(handler, column, row, left, right, top, bottom);
    }
    
    @Override
    protected void loadInfo()
    {
        width = 100;
        height = 100;
        value = "Monk";
    }

    @Override
    protected void loadImages()
    {
        images.add(Asset.ui03.crop(6, 50, 38, 38));
        images.add(Asset.ui03.crop(190, 50, 38, 38));
        innerImage = Asset.monkAvatar.crop(0, 0, 351, 350);
        characterImage = Asset.monkAvatar.crop(0, 0, 351, 350);

        currentImage = images.get(0);
    }
}
