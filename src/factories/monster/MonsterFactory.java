package factories.monster;

import components.entities.dynamics.character.monster.Monster;

public interface MonsterFactory
{
    public Monster createMonster(String type, float x, float y);
}
