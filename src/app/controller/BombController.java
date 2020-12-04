package app.controller;

import java.util.ArrayList;

import app.model.BombModel;
import core.entity.bomb.Bomb;

public class BombController
{
    public static ArrayList<Bomb> trash = new ArrayList<Bomb>();

    public ArrayList<Bomb> getBombs()
    {
        return BombModel.all();
    }

    public void createBomb(Bomb bomb)
    {
        // Clone the object and add it to the data
        try {
            BombModel.insert((Bomb) bomb.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void updateBomb(int index, Bomb bomb)
    {
        BombModel.update(index, bomb);
    }

    public void destroyBomb(Bomb bomb)
    {
        BombModel.delete(bomb);
    }
}
