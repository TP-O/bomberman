package components.actions.attack.nonstop;

import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.actions.collide.entity.MonsterCollision;
import factories.monster.*;
import app.cache.*;

public class ReleaseSuicideMonster extends AttackDecorator {

    private Collision collision;
    MonsterFactory factory = new BasicMonsterFactory();

    public ReleaseSuicideMonster(Attack attack) {
        super(attack);
        collision = new CollisionAction(attack.getAttacker());
        collision = new MonsterCollision(collision);
        
    }

    @Override
    protected void decorate() {
        
        if(!(factory.createMonster("Suicide", this.getAttacker().getX() + 80.0f, this.getAttacker().getY() + 0.0f).getMove().getCollision().isCollided())) { 
            EntityCache.push("monster", factory.createMonster("Suicide", this.getAttacker().getX() + 80.0f, this.getAttacker().getY() + 0.0f)); //right
        }

        if(!(factory.createMonster("Suicide", this.getAttacker().getX() + 0.0f, this.getAttacker().getY() + 80.0f).getMove().getCollision().isCollided())) {   
            EntityCache.push("monster", factory.createMonster("Suicide", this.getAttacker().getX() + 0.0f, this.getAttacker().getY() + 80.0f)); //up 
        }

        if(!(factory.createMonster("Suicide", this.getAttacker().getX() + 0.0f, this.getAttacker().getY() - 80.0f).getMove().getCollision().isCollided())) {   
            EntityCache.push("monster", factory.createMonster("Suicide", this.getAttacker().getX() + 0.0f, this.getAttacker().getY() - 80.0f)); //down
        }

        if(!(factory.createMonster("Suicide", this.getAttacker().getX() - 80.0f, this.getAttacker().getY() + 0.0f).getMove().getCollision().isCollided())) {
            EntityCache.push("monster", factory.createMonster("Suicide", this.getAttacker().getX() - 80.0f, this.getAttacker().getY() + 0.0f)); //left  
        }
    }

}
