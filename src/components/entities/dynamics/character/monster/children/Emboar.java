package components.entities.dynamics.character.monster.children;

import asset.Asset;
import components.entities.dynamics.character.monster.Monster;

public class Emboar extends Monster
{
    public Emboar(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 16;
        health = 16;
        speed = 1.0f;
        damage = 7;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.redBoss.crop(0, 2898, 852, 943));
        upFrames.add(Asset.redBoss.crop(952, 2884, 852, 943));
        upFrames.add(Asset.redBoss.crop(1918, 2891, 852, 943));

        downFrames.add(Asset.redBoss.crop(0, 0, 852, 951));
        downFrames.add(Asset.redBoss.crop(961, 0, 852, 951));
        downFrames.add(Asset.redBoss.crop(1913, 0, 852, 951));

        leftFrames.add(Asset.redBoss.crop(64, 980, 852, 971));
        leftFrames.add(Asset.redBoss.crop(1037, 966, 852, 943));
        leftFrames.add(Asset.redBoss.crop(1967, 987, 852, 943));
        
        rightFrames.add(Asset.redBoss.crop(0, 1917, 852, 943));
        rightFrames.add(Asset.redBoss.crop(916, 1917, 852, 943));
        rightFrames.add(Asset.redBoss.crop(1917, 1938, 852, 943));

        standFrames.add(Asset.redBoss.crop(0, 0, 852, 951));
    }
}
