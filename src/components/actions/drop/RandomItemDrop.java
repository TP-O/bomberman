package components.actions.drop;

import components.entities.dynamic.character.monster.Monster;

public class RandomItemDrop extends ItemDrop
{
    public RandomItemDrop(Monster monster)
    {
        super(monster);
    }

    @Override
    public void drop()
    {
        int chance = random.nextInt(2);

        if (chance == 0) {
            super.drop();
        }
    }   
}
