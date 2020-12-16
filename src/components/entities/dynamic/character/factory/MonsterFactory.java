package components.entities.dynamic.character.factory;

import core.Handler;
import components.entities.dynamic.character.Character;
import components.entities.dynamic.character.monster.children.*;

public class MonsterFactory extends CharacterFactory
{
    @Override
    public Character createCharacter(Handler handler, String type, float x, float y)
    {
        switch (type) {
            case "AlolanPersian":
                return new AlolanPersian(handler, x, y);
        
            case "ShinyZygarde":
                return new ShinyZygarde(handler, x, y);

            case "Scorbunny":
                return new Scorbunny(handler, x, y);

            case "Bulbasaur":
                return new Bulbasaur(handler, x, y);

            case "Emboar":
                return new Emboar(handler, x, y);

            case "ShinyEmboar":
                return new ShinyEmboar(handler, x, y);

            default:
                throw new Error("Can not find monster: " + type);
        }
    }
}
