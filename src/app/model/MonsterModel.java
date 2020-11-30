package app.model;

import java.util.ArrayList;
import java.util.List;

import core.entity.character.monster.Monster;

public class MonsterModel
{
    private static ArrayList<Monster> data = new ArrayList<Monster>();

    public static ArrayList<Monster> all()
    {
        return data;
    }

    public static void insert(Monster monster)
    {
        data.add(monster);
    }

    public static void insert(List<Monster> monsters)
    {
        data.addAll(monsters);
    }

    public static void delete(Monster monster)
    {
        data.remove(monster);
    }
}
