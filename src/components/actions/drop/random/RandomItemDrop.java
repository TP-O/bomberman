package components.actions.drop.random;

import components.actions.drop.Drop;
import components.actions.drop.nonstop.ItemDrop;

public class RandomItemDrop extends ItemDrop
{
    public RandomItemDrop(Drop drop)
    {
        super(drop);
    }

    @Override
    public void decorate()
    {
        int chance = random.nextInt(2);

        if (chance == 0) {
            super.decorate();
        }
    }
}
