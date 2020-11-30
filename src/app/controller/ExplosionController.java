package app.controller;

import java.util.ArrayList;

import app.model.ExplosionModel;
import core.entity.explosion.Explosion;

public class ExplosionController
{
    public static ArrayList<Explosion> trash = new ArrayList<Explosion>();

    public ArrayList<Explosion> getExplosions()
    {
        return ExplosionModel.all();
    }

    public void createExplosion(Explosion explosion)
    {
        ExplosionModel.insert(explosion);
    }

    public void destroyExplosion(Explosion explosion)
    {
        ExplosionModel.delete(explosion);
    }   
}
