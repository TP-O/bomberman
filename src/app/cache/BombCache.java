package app.cache;

import java.util.ArrayList;
import java.util.List;

import components.entities.fixed.bomb.Bomb;

public class BombCache implements Cache<Bomb>
{
    private static List<Bomb> data = new ArrayList<Bomb>();

    private static long createdTime = System.currentTimeMillis();

    @Override
    public List<Bomb> get()
    {
        return data;
    }

    @Override
    public void store(List<Bomb> data)
    {
        BombCache.data = data;
    }

    @Override
    public void insert(Bomb data)
    {
        long now = System.currentTimeMillis();

        if (now - createdTime > 1000) {
            createdTime = now;

            BombCache.data.add(data);
        }
    }

    @Override
    public void insert(List<Bomb> data)
    {
        long now = System.currentTimeMillis();

        if (now - createdTime > 1000) {
            createdTime = now;

            BombCache.data.addAll(data);
        }
    }

    @Override
    public void delete(Bomb data)
    {
        BombCache.data.remove(data);
    }
}
