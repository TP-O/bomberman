package components.entities.dynamics.characters.monster.children;

import asset.Asset;
import components.entities.dynamics.characters.monster.Monster;

public class Bulbasaur extends Monster {

    public Bulbasaur(float x, float y) {
        super(x, y);
    }

    @Override
    protected void setEntityParameters() {
        super.setEntityParameters();

        life = 5;
        health = 5;
        damage = 20;
    }

    @Override
    protected void loadAllFrames() {
        super.loadAllFrames();

        upFrames.add(Asset.get("bulbasaur").crop(34, 400, 76, 76));
        upFrames.add(Asset.get("bulbasaur").crop(280, 400, 76, 76));
        upFrames.add(Asset.get("bulbasaur").crop(155, 400, 76, 76));
        upFrames.add(Asset.get("bulbasaur").crop(280, 400, 76, 76));

        downFrames.add(Asset.get("bulbasaur").crop(34, 33, 76, 76));
        downFrames.add(Asset.get("bulbasaur").crop(154, 33, 76, 76));
        downFrames.add(Asset.get("bulbasaur").crop(276, 33, 76, 76));
        downFrames.add(Asset.get("bulbasaur").crop(398, 33, 76, 76));

        leftFrames.add(Asset.get("bulbasaur").crop(34, 151, 76, 76));
        leftFrames.add(Asset.get("bulbasaur").crop(156, 151, 76, 76));
        leftFrames.add(Asset.get("bulbasaur").crop(280, 151, 76, 76));
        leftFrames.add(Asset.get("bulbasaur").crop(400, 151, 76, 76));

        rightFrames.add(Asset.get("bulbasaur").crop(39, 271, 76, 76));
        rightFrames.add(Asset.get("bulbasaur").crop(159, 271, 76, 76));
        rightFrames.add(Asset.get("bulbasaur").crop(281, 271, 76, 76));
        rightFrames.add(Asset.get("bulbasaur").crop(403, 271, 76, 76));

        standFrames.add(Asset.get("bulbasaur").crop(6, 13, 42, 42));
    }
}
