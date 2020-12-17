package components.entities.dynamic.character.monster.children;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import asset.Asset;
import components.entities.dynamic.character.monster.Monster;
import core.Handler;

public class Emboar extends Monster
{
    public Emboar(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        health = 16;
        maxHealth = 16;
        speed = 1.0f;
        damage = 7;
    }

    @Override
    protected void loadAllFrames()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.redBoss.crop(0, 2898, 852, 943));
        up.add(Asset.redBoss.crop(952, 2884, 852, 943));
        up.add(Asset.redBoss.crop(1918, 2891, 852, 943));

        down.add(Asset.redBoss.crop(0, 0, 852, 951));
        down.add(Asset.redBoss.crop(961, 0, 852, 951));
        down.add(Asset.redBoss.crop(1913, 0, 852, 951));

        left.add(Asset.redBoss.crop(64, 980, 852, 971));
        left.add(Asset.redBoss.crop(1037, 966, 852, 943));
        left.add(Asset.redBoss.crop(1967, 987, 852, 943));
        
        right.add(Asset.redBoss.crop(0, 1917, 852, 943));
        right.add(Asset.redBoss.crop(916, 1917, 852, 943));
        right.add(Asset.redBoss.crop(1917, 1938, 852, 943));

        stand.add(Asset.redBoss.crop(0, 0, 852, 951));
    }
}
