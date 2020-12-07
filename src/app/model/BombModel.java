package app.model;

import java.util.ArrayList;

import entity.bomb.Bomb;

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
}
