package components.entities.statics.items;

import components.entities.dynamics.characters.player.Player;
import components.entities.statics.StaticEntity;

public abstract class Item extends StaticEntity {

    protected int timer;

    protected long createdTime;

    @Override
    protected void setEntityParameters() {
        margin = 0;
        padding = 0;
        createdTime = System.currentTimeMillis();
    }

    @Override
    public void tick() {
        long now = System.currentTimeMillis();

        // The item will be deleted if the time is up
        if (now - createdTime >= timer) {
            deleted = true;
        } else {
            super.tick();
        }
    }

    public abstract void boost(Player player);
}
