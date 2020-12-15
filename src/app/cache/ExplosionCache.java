package app.cache;

import java.util.ArrayList;
import java.util.List;

import components.entities.fixed.explosion.Explosion;

public class ExplosionCache implements Cache<Explosion>
{
    private static List<Explosion> data = new ArrayList<Explosion>();

    @Override
    public List<Explosion> get()
    {
        return data;
    }

    @Override
    public void store(List<Explosion> data)
    {
        ExplosionCache.data = data;
    }

    @Override
    public void insert(Explosion data)
    {
        ExplosionCache.data.add(data);
    }

    @Override
    public void insert(List<Explosion> data)
    {
        ExplosionCache.data.addAll(data);
    }

    @Override
    public void delete(Explosion data)
    {
        ExplosionCache.data.remove(data);
    }
}
