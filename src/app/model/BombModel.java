package app.model;

import java.util.ArrayList;
import java.util.List;

import core.entity.bomb.Bomb;

public class BombModel
{
    private static long createdTime = System.currentTimeMillis();

    private static ArrayList<Bomb> data = new ArrayList<Bomb>();

    public static ArrayList<Bomb> all()
    {
        return data;
    }
    
    public static void insert(Bomb bomb)
    {
        long now = System.currentTimeMillis();

        if (now - createdTime > 1000) {
            data.add(bomb);
            createdTime = now;
        }
    }

    public static void insert(List<Bomb> bombs)
    {
        long now = System.currentTimeMillis();

        if (now - createdTime > 1000) {
            data.addAll(bombs);
            createdTime = now;
        }
    }

    public static void update(int index, Bomb bomb)
    {
        data.set(index, bomb);
    }

    public static void delete(Bomb bomb)
    {
        data.remove(bomb);
    }
}
