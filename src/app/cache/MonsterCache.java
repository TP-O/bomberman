package app.cache;

import java.util.ArrayList;
import java.util.List;

import components.entities.dynamic.character.monster.Monster;

public class MonsterCache implements Cache<Monster>
{
    private static List<Monster> data = new ArrayList<Monster>();

    @Override
    public List<Monster> get()
    {
        return data;
    }

    @Override
    public void store(List<Monster> data)
    {
        MonsterCache.data = data;
    }

    @Override
    public void insert(Monster data)
    {
        MonsterCache.data.add(data);
    }

    @Override
    public void insert(List<Monster> data)
    {
        MonsterCache.data.addAll(data);
    }

    @Override
    public void delete(Monster data)
    {
        MonsterCache.data.remove(data);
    }
}
