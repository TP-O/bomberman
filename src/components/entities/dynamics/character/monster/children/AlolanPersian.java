package components.entities.dynamics.character.monster.children;

import asset.Asset;
import components.entities.dynamics.character.monster.Monster;

public class AlolanPersian extends Monster
{
    public AlolanPersian(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 10;
        health = 10;
        speed = 1.1f;
        damage = 5;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.alolanPersian.crop(10, 202, 128, 112));
        upFrames.add(Asset.alolanPersian.crop(172, 202, 128, 112));
        
        downFrames.add(Asset.alolanPersian.crop(6, 20, 128, 137));
        downFrames.add(Asset.alolanPersian.crop(167, 20, 128, 137));

        leftFrames.add(Asset.alolanPersian.crop(20, 371, 137, 112));
        leftFrames.add(Asset.alolanPersian.crop(177, 371, 137, 112));
        
        rightFrames.add(Asset.alolanPersian.crop(4, 528, 137, 112));
        rightFrames.add(Asset.alolanPersian.crop(168, 528, 137, 112));

        standFrames.add(Asset.alolanPersian.crop(6, 20, 128, 137));
    }
}
