package entity.character.monster.children;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import asset.Asset;
import core.main.Handler;
import entity.character.monster.Monster;

public class Scorbunny extends Monster
{
    public Scorbunny(Handler handler, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(handler, x, y, width, height, health, damage, speed);
    }

    protected void loadCharacterImage()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.scorbunny.crop(12, 90, 56, 58));
        up.add(Asset.scorbunny.crop(91, 90, 56, 58));
        
        down.add(Asset.scorbunny.crop(12, 11, 56, 58));
        down.add(Asset.scorbunny.crop(92, 11, 56, 58));

        left.add(Asset.scorbunny.crop(12, 172, 56, 58));
        left.add(Asset.scorbunny.crop(90, 171, 56, 58));
        
        right.add(Asset.scorbunny.crop(8, 250, 56, 58));
        right.add(Asset.scorbunny.crop(87, 250, 56, 58));

        stand.add(Asset.scorbunny.crop(12, 11, 56, 58));
    }
}