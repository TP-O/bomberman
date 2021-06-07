package components.actions.drop.random;

import components.actions.drop.Drop;
import components.actions.drop.nonstop.ItemDrop;

public class RandomItemDrop extends ItemDrop {

    private int rate = 10;

    public RandomItemDrop(Drop drop) {
        super(drop);
    }

    public RandomItemDrop(Drop drop, int rate) {
        super(drop);

        this.rate = rate;
    }

    @Override
    protected void decorate() {
        int chance = random.nextInt(rate);

        if (chance == 0) {
            super.decorate();
        }
    }
}
