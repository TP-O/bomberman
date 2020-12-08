package entity.character.player.children;

import java.util.ArrayList;

import java.awt.image.BufferedImage;
import asset.Asset;
import core.main.Handler;
import entity.character.player.Player;

public class Kid extends Player
{
    public Kid(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void loadInfo()
    {
        super.loadInfo();

        health = 80;
        speed = 4.0f;
    }

    @Override
    protected void loadImages()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.kid.crop(252, 296, 177, 266));
        up.add(Asset.kid.crop(10, 296, 187, 243));
        up.add(Asset.kid.crop(527, 296, 177, 266));
        up.add(Asset.kid.crop(10, 296, 187, 243));
        
        down.add(Asset.kid.crop(252, 21, 177, 265));
        down.add(Asset.kid.crop(11, 21, 187, 243));
        down.add(Asset.kid.crop(505, 21, 177, 265));
        down.add(Asset.kid.crop(11, 21, 187, 243));
      
        left.add(Asset.kid.crop(263, 580, 155, 256));
        left.add(Asset.kid.crop(11, 580, 143, 245));
        left.add(Asset.kid.crop(515, 580, 155, 256));
        left.add(Asset.kid.crop(11, 580, 143, 245));
        
        right.add(Asset.kid.crop(284, 867, 155, 255));
        right.add(Asset.kid.crop(42, 867, 145, 244));
        right.add(Asset.kid.crop(525, 867, 155, 255));
        right.add(Asset.kid.crop(42, 867, 145, 244));

        stand.add(Asset.kid.crop(11, 21, 187, 243));
    }
}
