package components.entities.dynamic.character.monster.children;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import asset.Asset;
import components.entities.dynamic.character.monster.Monster;
import core.Handler;

public class ShinyZygarde extends Monster
{
    public ShinyZygarde(Handler handler, float x, float y)
    {
        super(handler, x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        health = 50;
        speed = 4.5f;
        damage = 1;
    }

    @Override
    protected void loadAllFrames()
    {
        up = new ArrayList<BufferedImage>();
        down = new ArrayList<BufferedImage>();
        left = new ArrayList<BufferedImage>();
        right = new ArrayList<BufferedImage>();
        stand = new ArrayList<BufferedImage>();

        up.add(Asset.shinyZygarde.crop(6, 182, 42, 42));
        up.add(Asset.shinyZygarde.crop(62, 182, 42, 42));
        up.add(Asset.shinyZygarde.crop(119, 182, 42, 42));
        up.add(Asset.shinyZygarde.crop(175, 182, 42, 42));
        
        down.add(Asset.shinyZygarde.crop(6, 13, 42, 42));
        down.add(Asset.shinyZygarde.crop(62, 13, 42, 42));
        down.add(Asset.shinyZygarde.crop(118, 13, 42, 42));
        down.add(Asset.shinyZygarde.crop(175, 13, 42, 42));

        left.add(Asset.shinyZygarde.crop(10, 74, 44, 38));
        left.add(Asset.shinyZygarde.crop(66, 74, 44, 38));
        left.add(Asset.shinyZygarde.crop(122, 74, 44, 38));
        left.add(Asset.shinyZygarde.crop(176, 74, 44, 38));
        
        right.add(Asset.shinyZygarde.crop(7, 127, 44, 38));
        right.add(Asset.shinyZygarde.crop(62, 128, 44, 38));
        right.add(Asset.shinyZygarde.crop(119, 127, 44, 38));
        right.add(Asset.shinyZygarde.crop(173, 128, 44, 38));

        stand.add(Asset.shinyZygarde.crop(6, 13, 42, 42));
    }
}
