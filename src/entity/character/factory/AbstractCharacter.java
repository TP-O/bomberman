package entity.character.factory;

import core.main.Handler;
import entity.character.Character;

public interface AbstractCharacter
{
    public Character createCharacter(Handler handler, String type,
            float x, float y,  int width, int height, int health, int damage, float speed);
}
