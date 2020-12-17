package components.entities.dynamics.character.monster.children;

import asset.Asset;
import components.entities.dynamics.character.monster.Monster;

public class ShinyZygarde extends Monster
{
    public ShinyZygarde(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 50;
        health = 50;
        speed = 4.5f;
        damage = 1;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.shinyZygarde.crop(6, 182, 42, 42));
        upFrames.add(Asset.shinyZygarde.crop(62, 182, 42, 42));
        upFrames.add(Asset.shinyZygarde.crop(119, 182, 42, 42));
        upFrames.add(Asset.shinyZygarde.crop(175, 182, 42, 42));
        
        downFrames.add(Asset.shinyZygarde.crop(6, 13, 42, 42));
        downFrames.add(Asset.shinyZygarde.crop(62, 13, 42, 42));
        downFrames.add(Asset.shinyZygarde.crop(118, 13, 42, 42));
        downFrames.add(Asset.shinyZygarde.crop(175, 13, 42, 42));

        leftFrames.add(Asset.shinyZygarde.crop(10, 74, 44, 38));
        leftFrames.add(Asset.shinyZygarde.crop(66, 74, 44, 38));
        leftFrames.add(Asset.shinyZygarde.crop(122, 74, 44, 38));
        leftFrames.add(Asset.shinyZygarde.crop(176, 74, 44, 38));
        
        rightFrames.add(Asset.shinyZygarde.crop(7, 127, 44, 38));
        rightFrames.add(Asset.shinyZygarde.crop(62, 128, 44, 38));
        rightFrames.add(Asset.shinyZygarde.crop(119, 127, 44, 38));
        rightFrames.add(Asset.shinyZygarde.crop(173, 128, 44, 38));

        standFrames.add(Asset.shinyZygarde.crop(6, 13, 42, 42));
    }
}
