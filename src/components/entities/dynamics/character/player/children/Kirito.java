package components.entities.dynamics.character.player.children;

import asset.Asset;
import components.entities.dynamics.character.player.Player;

public class Kirito extends Player
{
    public Kirito(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 120;
        health = 120;
        speed = 2.2f;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.kirito.crop(7, 147, 33, 44));
        upFrames.add(Asset.kirito.crop(54, 146, 34, 45));
        upFrames.add(Asset.kirito.crop(102, 147, 34, 44));
        upFrames.add(Asset.kirito.crop(54, 146, 34, 45));

        downFrames.add(Asset.kirito.crop(7, 3, 30, 44));
        downFrames.add(Asset.kirito.crop(56, 2, 29, 45));
        downFrames.add(Asset.kirito.crop(103, 3, 30, 44));
        downFrames.add(Asset.kirito.crop(56, 2, 29, 45));

        leftFrames.add(Asset.kirito.crop(5, 52, 34, 43));
        leftFrames.add(Asset.kirito.crop(53, 51, 34, 44));
        leftFrames.add(Asset.kirito.crop(101, 52, 34, 43));
        leftFrames.add(Asset.kirito.crop(53, 51, 34, 44));
        
        rightFrames.add(Asset.kirito.crop(7, 100, 33, 43));
        rightFrames.add(Asset.kirito.crop(55, 99, 32, 44));
        rightFrames.add(Asset.kirito.crop(103, 100, 33, 43));
        rightFrames.add(Asset.kirito.crop(55, 99, 32, 44));

        standFrames.add(Asset.kirito.crop(56, 2, 29, 45));
    }
}
