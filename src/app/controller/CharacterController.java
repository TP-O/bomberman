package app.controller;

import java.util.ArrayList;
import java.util.List;

import core.entity.character.Character;
import core.entity.character.CharacterBuilder;

public class CharacterController
{
    private static Character player;

    private static ArrayList<Character> monsters = new ArrayList<Character>();

    public static CharacterBuilder builder = new CharacterBuilder();

    public static Character getPlayer()
    {
        if (CharacterController.player == null) {
            throw new Error("Can not find Player");
        }

        return CharacterController.player;
    }

    public static void setPlayer(Character player)
    {
        CharacterController.player = player;
    }

    public static ArrayList<Character> getMonsters()
    {
        return CharacterController.monsters;
    }

    public static void setMonsters(List<Character> monsters)
    {
        CharacterController.monsters.addAll(monsters);
    }

    public static void destroyMonster(Character monster)
    {
        CharacterController.monsters.remove(monster);
    }
}
