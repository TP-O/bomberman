package entity.character.player.children;

import java.util.ArrayList;

import java.awt.image.BufferedImage;
import asset.Asset;
import core.main.Handler;
import entity.character.player.Player;

public class Satoshi extends Player
{
    public Satoshi(Handler handler, float x, float y, int width, int height, int health, int damage, float speed)
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

        up.add(Asset.satoshi.crop(76, 201, 35, 50));
        up.add(Asset.satoshi.crop(12, 203, 35, 46));
        up.add(Asset.satoshi.crop(204, 201, 35, 50));
        up.add(Asset.satoshi.crop(12, 203, 35, 46));

        down.add(Asset.satoshi.crop(77, 9, 35, 50));
        down.add(Asset.satoshi.crop(13, 11, 35, 46));
        down.add(Asset.satoshi.crop(205, 9, 35, 50));
        down.add(Asset.satoshi.crop(13, 11, 35, 46));

        left.add(Asset.satoshi.crop(77, 72, 39, 49));
        left.add(Asset.satoshi.crop(13, 74, 39, 47));
        left.add(Asset.satoshi.crop(205, 72, 39, 47));
        left.add(Asset.satoshi.crop(13, 74, 39, 47));
        
        right.add(Asset.satoshi.crop(75, 137, 39, 48));
        right.add(Asset.satoshi.crop(11, 139, 39, 46));
        right.add(Asset.satoshi.crop(203, 137, 39, 46));
        right.add(Asset.satoshi.crop(11, 139, 39, 46));

        stand.add(Asset.satoshi.crop(13, 11, 34, 46));
    }
}
