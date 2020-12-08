package entity.character.player.children;

import java.util.ArrayList;

import java.awt.image.BufferedImage;
import asset.Asset;
import core.main.Handler;
import entity.character.player.Player;

public class Monk extends Player
{
    public Monk(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void loadInfo()
    {
        super.loadInfo();

        health = 60;
        speed = 4.5f;
    }

    @Override
    protected void loadImages()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.monk.crop(436, 701, 357, 454));
        up.add(Asset.monk.crop(24, 679, 357, 454));
        up.add(Asset.monk.crop(1214, 698, 357, 454));
        up.add(Asset.monk.crop(24, 679, 357, 454));

        down.add(Asset.monk.crop(433, 98, 357, 454));
        down.add(Asset.monk.crop(23, 98, 357, 454));
        down.add(Asset.monk.crop(1212, 98, 357, 454));
        down.add(Asset.monk.crop(23, 98, 357, 454));

        left.add(Asset.monk.crop(423, 1272, 357, 454));
        left.add(Asset.monk.crop(29, 1273, 357, 454));
        left.add(Asset.monk.crop(423, 1272, 357, 454));
        left.add(Asset.monk.crop(29, 1273, 357, 454));
        
        right.add(Asset.monk.crop(24, 1876, 357, 454));
        right.add(Asset.monk.crop(419, 1873, 357, 454));
        right.add(Asset.monk.crop(24, 1876, 357, 454));
        right.add(Asset.monk.crop(419, 1873, 357, 454));

        stand.add(Asset.monk.crop(23, 98, 357, 454));
    }
}
