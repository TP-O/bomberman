package components.entities.statics.bombs.children;

import asset.Asset;
import components.behaviors.attack.PlusExplosionAttack;
import components.entities.statics.bombs.Bomb;
import components.entities.statics.explosions.children.ExplosionA;

public class BombB extends Bomb
{
    @Override
    protected void setEntityParameters()
    {
        range = 5;
        width = 32;
        height = 32;
        timer = 1000;

        explosion = new ExplosionA();
    }

    @Override
    protected void initializeActions()
    {
        super.initializeActions();

        attack = new PlusExplosionAttack(this, explosion, range);
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        frames.add(Asset.bomb.crop(8, 11, 207, 196));
        frames.add(Asset.bomb.crop(218, 7, 207, 196));
        frames.add(Asset.bomb.crop(447, 7, 207, 196));
        frames.add(Asset.bomb.crop(647, 7, 207, 196));
        frames.add(Asset.bomb.crop(852, 7, 207, 196));
        frames.add(Asset.bomb.crop(1054, 7, 207, 196));
    }

    @Override
    public void tick()
    {
        long now = System.currentTimeMillis();

        // The bomb will be deleted if the time is up
        if (now - createdTime >= timer) {
            // Attackkk
            attack.attack();
            
            // Delete
            delete();
        }
        else {
            super.tick();
        }
    }
}
