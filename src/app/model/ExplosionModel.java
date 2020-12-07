package app.model;

import java.util.ArrayList;
import java.util.List;

import entity.explosion.Explosion;

public class ExplosionModel
{
    private static ArrayList<Explosion> data = new ArrayList<Explosion>();

    public static ArrayList<Explosion> all()
    {
        return data;
    }
    
    public static void insert(Explosion explosion)
    {
        data.add(explosion);
    }

    public static void insert(List<Explosion> explosions)
    {
        data.addAll(explosions);
    }

    public static void delete(Explosion explosion)
    {
        data.remove(explosion);
    }
}
