package components.entities.dynamics.character.player.children;

import asset.Asset;
import components.entities.dynamics.character.player.Player;

public class Goku extends Player
{
    public Goku(float x, float y)
    {
        super(x, y);
    }

    @Override
    protected void setEntityParameters()
    {
        super.setEntityParameters();

        life = 100;
        health = 100;
        speed = 3.0f;
    }

    @Override
    protected void loadAllFrames()
    {
        super.loadAllFrames();
        
        upFrames.add(Asset.goku.crop(77, 193, 41, 62));
        upFrames.add(Asset.goku.crop(13, 195, 41, 60));
        upFrames.add(Asset.goku.crop(205, 193, 41, 62));
        upFrames.add(Asset.goku.crop(13, 195, 41, 60));
        
        downFrames.add(Asset.goku.crop(73, 1, 41, 62));
        downFrames.add(Asset.goku.crop(9, 3, 41, 60));
        downFrames.add(Asset.goku.crop(201, 1, 41, 62));
        downFrames.add(Asset.goku.crop(9, 3, 41, 60));

        leftFrames.add(Asset.goku.crop(73, 64, 41, 62));
        leftFrames.add(Asset.goku.crop(9, 67, 41, 60));
        leftFrames.add(Asset.goku.crop(201, 64, 41, 62));
        leftFrames.add(Asset.goku.crop(9, 67, 41, 60));
        
        rightFrames.add(Asset.goku.crop(77, 127, 41, 62));
        rightFrames.add(Asset.goku.crop(13, 131, 41, 60));
        rightFrames.add(Asset.goku.crop(205, 127, 41, 62));
        rightFrames.add(Asset.goku.crop(13, 131, 41, 60));

        standFrames.add(Asset.goku.crop(9, 3, 41, 60));
    }
}
