package app.controller;

import java.util.ArrayList;

import core.entity.character.Character;
import core.entity.character.CharacterBuilder;

public class CharacterController
{
    private ArrayList<Character> characters;

    public static final int PLAYER_INDEX = 0;

    public static CharacterBuilder builder = new CharacterBuilder();

    public CharacterController()
    {
        this.characters = new ArrayList<Character>();
    }

    public ArrayList<Character> getCharacters()
    {
        return characters;
    }

    public Character getPlayer()
    {
        if (characters.get(0) == null) {
            throw new Error("Can not find Player");
        }
        return characters.get(0);
    }

    public void create(Character character)
    {
        this.characters.add(character);
    }

    public void destroy(Character character)
    {
        this.characters.remove(character);
    }
}
