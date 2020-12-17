package components.entities.dynamics.character.player.children;

import asset.Asset;
import components.entities.dynamics.character.player.Player;

public class Kid extends Player
{
    public Kid(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 80;
        health = 80;
        speed = 4.0f;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();

        upFrames.add(Asset.kid.crop(252, 296, 177, 266));
        upFrames.add(Asset.kid.crop(10, 296, 187, 243));
        upFrames.add(Asset.kid.crop(527, 296, 177, 266));
        upFrames.add(Asset.kid.crop(10, 296, 187, 243));
        
        downFrames.add(Asset.kid.crop(252, 21, 177, 265));
        downFrames.add(Asset.kid.crop(11, 21, 187, 243));
        downFrames.add(Asset.kid.crop(505, 21, 177, 265));
        downFrames.add(Asset.kid.crop(11, 21, 187, 243));
      
        leftFrames.add(Asset.kid.crop(263, 580, 155, 256));
        leftFrames.add(Asset.kid.crop(11, 580, 143, 245));
        leftFrames.add(Asset.kid.crop(515, 580, 155, 256));
        leftFrames.add(Asset.kid.crop(11, 580, 143, 245));
        
        rightFrames.add(Asset.kid.crop(284, 867, 155, 255));
        rightFrames.add(Asset.kid.crop(42, 867, 145, 244));
        rightFrames.add(Asset.kid.crop(525, 867, 155, 255));
        rightFrames.add(Asset.kid.crop(42, 867, 145, 244));

        standFrames.add(Asset.kid.crop(11, 21, 187, 243));
    }
}
