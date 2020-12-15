package components.entities.dynamic.character.factory;

import components.entities.dynamic.character.Character;
import core.Handler;

public abstract class CharacterFactory
{
    public abstract Character createCharacter(Handler handler, String type, float x, float y);
}
