package components.entities.dynamic.character.player.children;

import java.util.ArrayList;

import java.awt.image.BufferedImage;
import asset.Asset;
import components.entities.dynamic.character.player.Player;
import core.Handler;

public class Kirito extends Player
{
    public Kirito(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        health = 120;
        maxHealth = 120;
        speed = 2.2f;
    }

    @Override
    protected void loadAllFrames()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.kirito.crop(7, 147, 33, 44));
        up.add(Asset.kirito.crop(54, 146, 34, 45));
        up.add(Asset.kirito.crop(102, 147, 34, 44));
        up.add(Asset.kirito.crop(54, 146, 34, 45));

        down.add(Asset.kirito.crop(7, 3, 30, 44));
        down.add(Asset.kirito.crop(56, 2, 29, 45));
        down.add(Asset.kirito.crop(103, 3, 30, 44));
        down.add(Asset.kirito.crop(56, 2, 29, 45));

        left.add(Asset.kirito.crop(5, 52, 34, 43));
        left.add(Asset.kirito.crop(53, 51, 34, 44));
        left.add(Asset.kirito.crop(101, 52, 34, 43));
        left.add(Asset.kirito.crop(53, 51, 34, 44));
        
        right.add(Asset.kirito.crop(7, 100, 33, 43));
        right.add(Asset.kirito.crop(55, 99, 32, 44));
        right.add(Asset.kirito.crop(103, 100, 33, 43));
        right.add(Asset.kirito.crop(55, 99, 32, 44));

        stand.add(Asset.kirito.crop(56, 2, 29, 45));
    }
}
