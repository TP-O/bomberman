package app.controller;

import java.util.ArrayList;
import java.util.List;

import core.entity.character.Character;
import core.entity.character.CharacterBuilder;

public class CharacterController
{
    private ArrayList<Character> characters;

    public static final int PLAYER_INDEX = 0;

    public static CharacterBuilder builder = new CharacterBuilder();

    public CharacterController()
    {
        characters = new ArrayList<Character>();
    }

    public ArrayList<Character> getCharacters()
    {
        return characters;
    }

    public Character getPlayer()
    {
        if (characters.get(PLAYER_INDEX) == null) {
            throw new Error("Can not find Player");
        }

        return characters.get(PLAYER_INDEX);
    }

    public void setPlayer(Character player)
    {
        characters.add(PLAYER_INDEX, player);
    }

    public void create(List<Character> monsters)
    {
        characters.addAll(monsters);
    }

    public void destroy(Character character)
    {
        characters.remove(character);
    }
}
