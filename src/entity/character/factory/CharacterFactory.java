package entity.character.factory;

import core.main.Handler;
import entity.character.Character;

public abstract class CharacterFactory
{
    public abstract Character createCharacter(Handler handler, String type, float x, float y);
}
