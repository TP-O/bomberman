package components.actions.attack.nonstop;

import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.actions.collide.Collision;
import components.actions.collide.CollisionAction;
import components.actions.collide.entity.MonsterCollision;
import components.entities.dynamics.characters.monster.Monster;
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
        
        if(!(createRightMonster().getMove().getCollision().isCollided())) { 
            EntityCache.push("monster", createRightMonster()); //right
        }

        if(!(createTopMonster().getMove().getCollision().isCollided())) {   
            EntityCache.push("monster", createTopMonster()); //up 
        }

        if(!(createBottomMonster().getMove().getCollision().isCollided())) {   
            EntityCache.push("monster", createBottomMonster()); //down
        }

        if(!createLeftMonster().getMove().getCollision().isCollided()) {
            EntityCache.push("monster", createLeftMonster()); //left  
        }
    }

    //Create Top Monster
    private Monster createTopMonster() {
        return factory.createMonster("Suicide", this.getAttacker().getX() + 0.0f, this.getAttacker().getY() + 80.0f);
    }

    //Create Bottom Monster
    private Monster createBottomMonster() {
        return factory.createMonster("Suicide", this.getAttacker().getX() + 0.0f, this.getAttacker().getY() - 80.0f);
    }

    //Create Left Monster
    private Monster createLeftMonster() {
        return factory.createMonster("Suicide", this.getAttacker().getX() - 80.0f, this.getAttacker().getY() + 0.0f);
    }

    //Create Right Monster
    private Monster createRightMonster() {
        return factory.createMonster("Suicide", this.getAttacker().getX() + 80.0f, this.getAttacker().getY() + 0.0f);
    }
}
