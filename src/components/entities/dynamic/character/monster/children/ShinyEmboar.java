package components.entities.dynamic.character.monster.children;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import asset.Asset;
import components.entities.dynamic.character.monster.Monster;
import core.Handler;

public class ShinyEmboar extends Monster
{
    public ShinyEmboar(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        health = 5;
        maxHealth = 5;
        speed = 0.8f;
        damage = 6;
    }

    @Override
    protected void loadAllFrames()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.redBoss.crop(2875, 2920, 844, 921));
        up.add(Asset.redBoss.crop(3827, 2906, 844, 921));
        up.add(Asset.redBoss.crop(4801, 2913, 844, 921));

        down.add(Asset.redBoss.crop(2877, 0, 852, 943));
        down.add(Asset.redBoss.crop(3836, 0, 852, 943));
        down.add(Asset.redBoss.crop(4795, 0, 852, 943));

        left.add(Asset.redBoss.crop(2942, 994, 852, 971));
        left.add(Asset.redBoss.crop(3929, 966, 852, 943));
        left.add(Asset.redBoss.crop(4829, 973, 852, 943));
        
        right.add(Asset.redBoss.crop(2876, 1953, 816, 900));
        right.add(Asset.redBoss.crop(3806, 1925, 816, 921));
        right.add(Asset.redBoss.crop(4807, 1953, 816, 921));

        stand.add(Asset.redBoss.crop(0, 0, 852, 951));
    }
}
