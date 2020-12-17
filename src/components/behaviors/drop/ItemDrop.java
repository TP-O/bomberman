package components.behaviors.drop;

import java.util.Random;

import app.cache.EntityCache;
import components.entities.dynamics.character.monster.Monster;
import components.entities.statics.items.Item;
import components.entities.statics.items.children.*;

public class ItemDrop implements DropBehavior
{
    private enum Type
    {
        LIFE,
        DAMAGE_POTION,
        SPEED_POTION,
        HEAL_POTION,
    }

    private Monster monster;

    private boolean dropped;

    protected static Random random = new Random();

    public ItemDrop(Monster monster)
    {
        this.monster = monster;
    }

    @Override
    public void drop()
    {
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

            item.setX(monster.getX());
            item.setY(monster.getY());

            EntityCache.push("item", item);
        }
    }
}
