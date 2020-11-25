package core.entity.character.player;

import java.util.ArrayList;

import app.controller.GameController;
import java.awt.image.BufferedImage;
import core.asset.Asset;

public class Kid extends Player
{
    public Kid(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
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

        down.add(Asset.kid.crop(250, 0, 190, 280));
        down.add(Asset.kid.crop(500, 0, 190, 280));
       
        up.add(Asset.kid.crop(250, 300, 190, 280));
        up.add(Asset.kid.crop(500, 300, 190, 280));
      
        left.add(Asset.kid.crop(250, 580, 190, 280));
        left.add(Asset.kid.crop(510, 580, 190, 280));
        
        right.add(Asset.kid.crop(280, 850, 190, 280));
        right.add(Asset.kid.crop(525, 850, 190, 280));

        stand.add(Asset.kid.crop(0, 0, 190, 280));
    }
}
