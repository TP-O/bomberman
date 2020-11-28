package core.entity.character.monster;

import java.util.ArrayList;
import app.controller.GameController;
import java.awt.image.BufferedImage;
import core.asset.Asset;

public class Cat extends Monster
{
    public Cat(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
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

        up.add(Asset.Cat.crop(19, 190, 116, 148));
        up.add(Asset.Cat.crop(178, 192, 121, 149));
        
        down.add(Asset.Cat.crop(19, 0, 118, 170));
        down.add(Asset.Cat.crop(178, 5, 123, 168));

        left.add(Asset.Cat.crop(16, 363, 142, 123));
        left.add(Asset.Cat.crop(176, 369, 142, 120));
        
        right.add(Asset.Cat.crop(0, 535, 146, 103));
        right.add(Asset.Cat.crop(163, 526, 152, 113));

        stand.add(Asset.Cat.crop(19, 0, 118, 170));
    }
}

