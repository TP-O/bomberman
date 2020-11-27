package core.entity.character.player;

import java.util.ArrayList;

import app.controller.GameController;
import java.awt.image.BufferedImage;
import core.asset.Asset;

public class Kirito extends Player
{
    public Kirito(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
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

        up.add(Asset.kirito.crop(7, 147, 33, 44));
        up.add(Asset.kirito.crop(54, 146, 34, 45));
        up.add(Asset.kirito.crop(102, 147, 34, 44));
        up.add(Asset.kirito.crop(54, 146, 34, 45));

        down.add(Asset.kirito.crop(7, 3, 30, 44));
        down.add(Asset.kirito.crop(56, 2, 29, 45));
        down.add(Asset.kirito.crop(103, 3, 30, 44));
        down.add(Asset.kirito.crop(56, 2, 29, 45));

        left.add(Asset.kirito.crop(5, 52, 34, 43));
        left.add(Asset.kirito.crop(53, 51, 34, 44));
        left.add(Asset.kirito.crop(101, 52, 34, 43));
        left.add(Asset.kirito.crop(53, 51, 34, 44));
        
        right.add(Asset.kirito.crop(7, 100, 33, 43));
        right.add(Asset.kirito.crop(55, 99, 32, 44));
        right.add(Asset.kirito.crop(103, 100, 33, 43));
        right.add(Asset.kirito.crop(55, 99, 32, 44));

        stand.add(Asset.kirito.crop(56, 2, 29, 45));
    }
}
