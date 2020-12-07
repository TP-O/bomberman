package entity.character.factory;

import core.main.Handler;
import entity.character.Character;
import entity.character.monster.children.*;

public class AbstractMonster implements AbstractCharacter
{
    @Override
    public Character createCharacter(Handler handler, String type,
            float x, float y, int width, int height, int health, int damage, float speed)
    {
        Character monster;

        switch (type) {
            case "AlolanPersian":
                monster = new AlolanPersian(handler, x, y, width, height, health, damage, speed);
                break;
        
            case "ShinyZygarde":
                monster = new ShinyZygarde(handler, x, y, width, height, health, damage, speed);
                break;

            case "Scorbunny":
                monster = new Scorbunny(handler, x, y, width, height, health, damage, speed);
                break;

            case "Bulbasaur":
                monster = new Bulbasaur(handler, x, y, width, height, health, damage, speed);
                break;

            case "Emboar":
                monster = new Emboar(handler, x, y, width, height, health, damage, speed);
                break;

            case "ShinyEmboar":
                monster = new ShinyEmboar(handler, x, y, width, height, health, damage, speed);
                break;

            default:
                throw new Error("Can not find monster: " + type);
        }

        return monster;
    }
}
