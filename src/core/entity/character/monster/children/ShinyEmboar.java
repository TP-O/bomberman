package core.entity.character.monster.children;

import java.util.ArrayList;
import app.controller.GameController;
import java.awt.image.BufferedImage;
import core.asset.Asset;
import core.entity.character.monster.Monster;

public class ShinyEmboar extends Monster
{
    public ShinyEmboar(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(gameController, x, y, width, height, health, damage, speed);
    }

    protected void loadCharacterImage()
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
