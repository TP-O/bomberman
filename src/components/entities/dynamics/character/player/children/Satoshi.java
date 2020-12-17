package components.entities.dynamics.character.player.children;

import asset.Asset;
import components.entities.dynamics.character.player.Player;

public class Satoshi extends Player
{
    public Satoshi(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 30;
        health = 30;
        speed = 5.5f;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.satoshi.crop(76, 201, 35, 50));
        upFrames.add(Asset.satoshi.crop(12, 203, 35, 46));
        upFrames.add(Asset.satoshi.crop(204, 201, 35, 50));
        upFrames.add(Asset.satoshi.crop(12, 203, 35, 46));

        downFrames.add(Asset.satoshi.crop(77, 9, 35, 50));
        downFrames.add(Asset.satoshi.crop(13, 11, 35, 46));
        downFrames.add(Asset.satoshi.crop(205, 9, 35, 50));
        downFrames.add(Asset.satoshi.crop(13, 11, 35, 46));

        leftFrames.add(Asset.satoshi.crop(77, 72, 39, 49));
        leftFrames.add(Asset.satoshi.crop(13, 74, 39, 47));
        leftFrames.add(Asset.satoshi.crop(205, 72, 39, 47));
        leftFrames.add(Asset.satoshi.crop(13, 74, 39, 47));
        
        rightFrames.add(Asset.satoshi.crop(75, 137, 39, 48));
        rightFrames.add(Asset.satoshi.crop(11, 139, 39, 46));
        rightFrames.add(Asset.satoshi.crop(203, 137, 39, 46));
        rightFrames.add(Asset.satoshi.crop(11, 139, 39, 46));

        standFrames.add(Asset.satoshi.crop(13, 11, 34, 46));
    }
}
