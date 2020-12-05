package core.entity.character.player.children;

import java.util.ArrayList;

import app.controller.GameController;
import java.awt.image.BufferedImage;
import core.asset.Asset;
import core.entity.character.player.Player;

public class Goku extends Player
{
    public Goku(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
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

        up.add(Asset.goku.crop(77, 193, 41, 62));
        up.add(Asset.goku.crop(13, 195, 41, 60));
        up.add(Asset.goku.crop(205, 193, 41, 62));
        up.add(Asset.goku.crop(13, 195, 41, 60));
        
        down.add(Asset.goku.crop(73, 1, 41, 62));
        down.add(Asset.goku.crop(9, 3, 41, 60));
        down.add(Asset.goku.crop(201, 1, 41, 62));
        down.add(Asset.goku.crop(9, 3, 41, 60));

        left.add(Asset.goku.crop(73, 64, 41, 62));
        left.add(Asset.goku.crop(9, 67, 41, 60));
        left.add(Asset.goku.crop(201, 64, 41, 62));
        left.add(Asset.goku.crop(9, 67, 41, 60));
        
        right.add(Asset.goku.crop(77, 127, 41, 62));
        right.add(Asset.goku.crop(13, 131, 41, 60));
        right.add(Asset.goku.crop(205, 127, 41, 62));
        right.add(Asset.goku.crop(13, 131, 41, 60));

        stand.add(Asset.goku.crop(9, 3, 41, 60));
    }
}
