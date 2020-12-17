package components.entities.dynamic.character.monster.children;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import asset.Asset;
import components.entities.dynamic.character.monster.Monster;
import core.Handler;

public class Bulbasaur extends Monster
{
    public Bulbasaur(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        health = 5;
        maxHealth = 5;
        damage = 20;
    }

    @Override
    protected void loadAllFrames()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.bulbasaur.crop(34, 400, 76, 76));
        up.add(Asset.bulbasaur.crop(280, 400, 76, 76));
        up.add(Asset.bulbasaur.crop(155, 400, 76, 76));
        up.add(Asset.bulbasaur.crop(280, 400, 76, 76));
        
        down.add(Asset.bulbasaur.crop(34, 33, 76, 76));
        down.add(Asset.bulbasaur.crop(154, 33, 76, 76));
        down.add(Asset.bulbasaur.crop(276, 33, 76, 76));
        down.add(Asset.bulbasaur.crop(398, 33, 76, 76));

        left.add(Asset.bulbasaur.crop(34, 151, 76, 76));
        left.add(Asset.bulbasaur.crop(156, 151, 76, 76));
        left.add(Asset.bulbasaur.crop(280, 151, 76, 76));
        left.add(Asset.bulbasaur.crop(400, 151, 76, 76));
        
        right.add(Asset.bulbasaur.crop(39, 271, 76, 76));
        right.add(Asset.bulbasaur.crop(159, 271, 76, 76));
        right.add(Asset.bulbasaur.crop(281, 271, 76, 76));
        right.add(Asset.bulbasaur.crop(403, 271, 76, 76));

        stand.add(Asset.bulbasaur.crop(6, 13, 42, 42));
    }
}
