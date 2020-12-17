package components.actions.drop;

import java.util.Random;

import app.cache.ItemCache;
import components.entities.dynamic.character.monster.Monster;
import components.entities.fixed.item.Item;
import components.entities.fixed.item.children.*;

public class ItemDrop extends Drop
{
    private enum Type
    {
        MAXHP_BOOST,
        DAMAGE_BOOST,
        SPEED_BOOST,
        HEALING,
    }

    private Monster monster;

    private ItemCache cache;

    protected Random random = new Random();

    public ItemDrop(Monster monster)
    {
        this.monster = monster;

        cache = new ItemCache();
    }

    @Override
    public void drop()
    {
        Item item = null;
        int typeIndex = random.nextInt(Type.values().length);

        switch (Type.values()[typeIndex]) {
            case MAXHP_BOOST:
                item = new Life(monster.getHandler());
                break;

            case DAMAGE_BOOST:
                item = new DamagePotion(monster.getHandler());
                break;

            case SPEED_BOOST:
                item = new SpeedPotion(monster.getHandler());
                break;

            case HEALING:
                item = new HealPotion(monster.getHandler());
                break;
        
            default:
                break;
        }

        item.setX(monster.getX());
        item.setY(monster.getY());
        item.setCreatedTime(System.currentTimeMillis());

        cache.insert(item);
    }
}
