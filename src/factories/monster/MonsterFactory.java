package factories.monster;

import core.Handler;
import components.entities.dynamic.character.monster.Monster;
import components.entities.dynamic.character.monster.children.*;

public class MonsterFactory
{
    public Monster createMonster(Handler handler, String type, float x, float y)
    {
        Monster monster = null;

        switch (type) {
            case "AlolanPersian":
                monster = new AlolanPersian(handler, x, y);
                break;

            case "Bulbasaur":
                monster = new Bulbasaur(handler, x, y);
                break;

            case "Emboar":
                monster = new Emboar(handler, x, y);
                break;

            case "Scorbunny":
                monster = new Scorbunny(handler, x, y);
                break;

            case "ShinyEmboar":
                monster = new ShinyEmboar(handler, x, y);
                break;

            case "ShinyZygarde":
                monster = new ShinyZygarde(handler, x, y);
                break;
        
            default:
                monster = null;
        }

        return monster;
    }
}
