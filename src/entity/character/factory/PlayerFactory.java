package entity.character.factory;

import core.main.Handler;
import entity.character.Character;
import entity.character.player.children.*;

public class PlayerFactory extends CharacterFactory
{
    @Override
    public Character createCharacter(Handler handler, String type, float x, float y)
    {
        switch (type) {
            case "Kid":
                return new Kid(handler, x, y);
        
            case "Monk":
                return new Monk(handler, x, y);

            case "Shadow":
                return new Shadow(handler, x, y);

            case "Kirito":
                return new Kirito(handler, x, y);

            case "Satoshi":
                return new Satoshi(handler, x, y);

            case "Goku":
                return new Goku(handler, x, y);

            default:
                throw new Error("Can not find player: " + type);
        }
    }
}
