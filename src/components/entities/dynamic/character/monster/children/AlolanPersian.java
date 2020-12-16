package components.entities.dynamic.character.monster.children;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import asset.Asset;
import components.entities.dynamic.character.monster.Monster;
import core.Handler;

public class AlolanPersian extends Monster
{
    public AlolanPersian(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        health = 10;
        maxHealth = 10;
        speed = 1.1f;
        damage = 5;
    }

    @Override
    protected void loadAllFrames()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.alolanPersian.crop(10, 202, 128, 112));
        up.add(Asset.alolanPersian.crop(172, 202, 128, 112));
        
        down.add(Asset.alolanPersian.crop(6, 20, 128, 137));
        down.add(Asset.alolanPersian.crop(167, 20, 128, 137));

        left.add(Asset.alolanPersian.crop(20, 371, 137, 112));
        left.add(Asset.alolanPersian.crop(177, 371, 137, 112));
        
        right.add(Asset.alolanPersian.crop(4, 528, 137, 112));
        right.add(Asset.alolanPersian.crop(168, 528, 137, 112));

        stand.add(Asset.alolanPersian.crop(6, 20, 128, 137));
    }
}
