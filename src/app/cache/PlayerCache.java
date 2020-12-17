package app.cache;

import java.util.ArrayList;
import java.util.List;

import components.entities.dynamic.character.player.Player;

public class PlayerCache implements Cache<Player>
{
    private static List<Player> data = new ArrayList<Player>();

    @Override
    public List<Player> get()
    {
        return data;
    }

    @Override
    public void store(List<Player> data)
    {
        PlayerCache.data = data;
    }

    @Override
    public void insert(Player data)
    {
        PlayerCache.data.add(data);
    }

    @Override
    public void insert(List<Player> data)
    {
        PlayerCache.data.addAll(data);
    }

    @Override
    public void delete(Player data)
    {
        PlayerCache.data.remove(data);
    }
}
