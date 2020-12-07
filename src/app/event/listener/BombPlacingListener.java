package app.event.listener;

import app.model.BombModel;
import entity.bomb.Bomb;

public class BombPlacingListener implements Listener
{
    private Bomb bomb;

    private float x;

    private float y;

    public BombPlacingListener(Bomb bomb, float x, float y)
    {
        this.bomb = bomb;
        this.x = x;
        this.y = y;
    }

    @Override
    public void handle()
    {
        bomb.setX(x);
        bomb.setY(y);
        bomb.setCreatedTime(System.currentTimeMillis());

        try {
            BombModel.insert((Bomb) bomb.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
