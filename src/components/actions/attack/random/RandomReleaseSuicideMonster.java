package components.actions.attack.random;

import java.util.Random;

import components.actions.attack.Attack;
import components.actions.attack.nonstop.ReleaseSuicideMonster;

public class RandomReleaseSuicideMonster extends ReleaseSuicideMonster {

    private static Random random = new Random();
    
    public RandomReleaseSuicideMonster(Attack attack) {
        super(attack);

    }

    @Override
    protected void decorate()
    {
        int chance = random.nextInt(100);

        if (chance == 0) {
            super.decorate();
        }
    }
    
}
