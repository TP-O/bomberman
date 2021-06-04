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
    private float[][] position = new float[4][2];

    public ReleaseSuicideMonster(Attack attack) {
        super(attack);
        collision = new CollisionAction(attack.getAttacker());
        collision = new MonsterCollision(collision);
    }

    @Override
    protected void decorate() {
        createMonster(position);

    }

    //Create Monster
    private void createMonster(float[][] position) {
        position[0][0] = this.getAttacker().getX();
        position[1][0] = this.getAttacker().getX();
        position[2][0] = this.getAttacker().getX() - this.getAttacker().getWidth() - 6;
        position[3][0] = this.getAttacker().getX() + this.getAttacker().getWidth() + 6;
        position[0][1] = this.getAttacker().getY() + this.getAttacker().getHeight() + 6;
        position[1][1] = this.getAttacker().getY() - this.getAttacker().getHeight() - 6;
        position[2][1] = this.getAttacker().getY();
        position[3][1] = this.getAttacker().getY();
        for (int i = 0; i < 4; i++) {
            Monster suicide = factory.createMonster("Suicide", position[i][0], position[i][1]);
            if(!(suicide.getMove().getCollision().isCollided())) { 
                EntityCache.push("monster", suicide); 
            }
        }
    }

}
