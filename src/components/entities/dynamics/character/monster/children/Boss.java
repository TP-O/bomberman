package components.entities.dynamics.character.monster.children;

import asset.Asset;
import components.actions.attack.random.RandomBombPlacing;
import components.entities.dynamics.character.monster.Monster;
import components.entities.statics.bombs.Bomb;
import components.entities.statics.bombs.children.BombB;

public class Boss extends Monster
{
    private Bomb bomb;

    public Boss(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 500;
        health = 500;
        speed = 8.0f;
        damage = 10;
        width = 130;
        height = 130;

        bomb = new BombB();
        bomb.getExplosion().setTargets(new String[] {
            "Player",
            "Block",
        });
    }

    @Override
    protected void initializeActions()
    {
        super.initializeActions();

        attack = new RandomBombPlacing(attack, bomb);
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.get("shinyzygarde").crop(0, 2898, 852, 943));
        upFrames.add(Asset.get("shinyzygarde").crop(952, 2884, 852, 943));
        upFrames.add(Asset.get("shinyzygarde").crop(1918, 2891, 852, 943));

        downFrames.add(Asset.get("shinyzygarde").crop(0, 0, 852, 951));
        downFrames.add(Asset.get("shinyzygarde").crop(961, 0, 852, 951));
        downFrames.add(Asset.get("shinyzygarde").crop(1913, 0, 852, 951));

        leftFrames.add(Asset.get("shinyzygarde").crop(64, 980, 852, 971));
        leftFrames.add(Asset.get("shinyzygarde").crop(1037, 966, 852, 943));
        leftFrames.add(Asset.get("shinyzygarde").crop(1967, 987, 852, 943));

        rightFrames.add(Asset.get("shinyzygarde").crop(0, 1917, 852, 943));
        rightFrames.add(Asset.get("shinyzygarde").crop(916, 1917, 852, 943));
        rightFrames.add(Asset.get("shinyzygarde").crop(1917, 1938, 852, 943));

        standFrames.add(Asset.get("shinyzygarde").crop(0, 0, 852, 951));
    }
}
