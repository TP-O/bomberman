package entity.character.player.children;

import java.util.ArrayList;

import java.awt.image.BufferedImage;
import asset.Asset;
import core.main.Handler;
import entity.character.player.Player;

public class Shadow extends Player
{
    public Shadow(Handler handler, float x, float y, int width, int height, int health, int damage, float speed)
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

        up.add(Asset.shadow.crop(77, 193, 38, 63));
        up.add(Asset.shadow.crop(13, 191, 38, 63));
        up.add(Asset.shadow.crop(205, 193, 38, 63));
        up.add(Asset.shadow.crop(13, 191, 38, 63));

        down.add(Asset.shadow.crop(77, 0, 38, 63));
        down.add(Asset.shadow.crop(13, 0, 38, 63));
        down.add(Asset.shadow.crop(205, 1, 38, 63));
        down.add(Asset.shadow.crop(13, 0, 38, 63));

        left.add(Asset.shadow.crop(79, 65, 38, 63));
        left.add(Asset.shadow.crop(15, 65, 38, 63));
        left.add(Asset.shadow.crop(207, 67, 38, 63));
        left.add(Asset.shadow.crop(15, 65, 38, 63));
        
        right.add(Asset.shadow.crop(75, 129, 38, 63));
        right.add(Asset.shadow.crop(11, 129, 38, 63));
        right.add(Asset.shadow.crop(203, 131, 38, 63));
        right.add(Asset.shadow.crop(11, 129, 38, 63));

        stand.add(Asset.shadow.crop(13, 0, 38, 63));
    }
}
