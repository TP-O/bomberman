package components.actions.drop.nonstop;

import java.util.Random;

import app.cache.EntityCache;
import components.actions.drop.Drop;
import components.actions.drop.DropDecorator;
import components.entities.statics.items.Item;
import components.entities.statics.items.children.*;

public class ItemDrop extends DropDecorator {

    private enum Type {
        LIFE,
        DAMAGE_POTION,
        SPEED_POTION,
        HEAL_POTION,
    }

    private boolean dropped;

    protected static Random random = new Random();

    public ItemDrop(Drop drop) {
        super(drop);
    }

    @Override
    protected void decorate() {
        if (!dropped) {
            dropped = true;
            Item item = null;
            int typeIndex = random.nextInt(Type.values().length);

            switch (Type.values()[typeIndex]) {
                case LIFE:
                    item = new Life();
                    break;

                case DAMAGE_POTION:
                    item = new DamagePotion();
                    break;

                case SPEED_POTION:
                    item = new SpeedPotion();
                    break;

                case HEAL_POTION:
                    item = new HealPotion();
                    break;

                default:
                    break;
            }

            item.setX(getEntity().getX());
            item.setY(getEntity().getY());

            EntityCache.push("item", item);
        }
    }
}
