package entity.character.factory;

import core.main.Handler;
import entity.character.Character;
import entity.character.player.children.*;

public class AbstractPlayer implements AbstractCharacter
{
    @Override
    public Character createCharacter(Handler handler, String type,
            float x, float y, int width, int height, int health, int damage, float speed)
    {
        Character player;

        switch (type) {
            case "Kid":
                player = new Kid(handler, x, y, width, height, health, damage, speed);
                break;
        
            case "Monk":
                player = new Monk(handler, x, y, width, height, health, damage, speed);
                break;

            case "Shadow":
                player = new Shadow(handler, x, y, width, height, health, damage, speed);
                break;

            case "Kirito":
                player = new Kirito(handler, x, y, width, height, health, damage, speed);
                break;

            case "Satoshi":
                player = new Satoshi(handler, x, y, width, height, health, damage, speed);
                break;

            case "Goku":
                player = new Goku(handler, x, y, width, height, health, damage, speed);
                break;

            default:
                throw new Error("Can not find player: " + type);
        }
        
        return player;
    }
}
