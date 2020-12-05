package core.entity.character.monster.children;

import java.util.ArrayList;
import app.controller.GameController;
import java.awt.image.BufferedImage;
import core.asset.Asset;
import core.entity.character.monster.Monster;

public class AlolanPersian extends Monster
{
    public AlolanPersian(GameController gameController, float x, float y, int width, int height,
            int health, int damage, float speed)
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
