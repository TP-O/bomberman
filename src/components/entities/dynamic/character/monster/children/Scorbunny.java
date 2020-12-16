package components.entities.dynamic.character.monster.children;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import asset.Asset;
import components.entities.dynamic.character.monster.Monster;
import core.Handler;

public class Scorbunny extends Monster
{
    public Scorbunny(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        health = 1;
        speed = 1.2f;
        damage = 25;
    }

    @Override
    protected void loadAllFrames()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.scorbunny.crop(12, 90, 56, 58));
        up.add(Asset.scorbunny.crop(91, 90, 56, 58));
        
        down.add(Asset.scorbunny.crop(12, 11, 56, 58));
        down.add(Asset.scorbunny.crop(92, 11, 56, 58));

        left.add(Asset.scorbunny.crop(12, 172, 56, 58));
        left.add(Asset.scorbunny.crop(90, 171, 56, 58));
        
        right.add(Asset.scorbunny.crop(8, 250, 56, 58));
        right.add(Asset.scorbunny.crop(87, 250, 56, 58));

        stand.add(Asset.scorbunny.crop(12, 11, 56, 58));
    }
}
