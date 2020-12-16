package app.event.listener;

import app.model.ItemModel;
import entity.item.Item;

public class KilledMonsterListener implements Listener
{
    private Item item;

    private float x;

    private float y;
    
    public KilledMonsterListener(Item item, float x, float y)
    {
        this.item = item;
        this.x = x;
        this.y = y;
    }

    @Override
    public void handle()
    {     
        item.setX(x);
        item.setY(y);
        
        item.setCreatedTime(System.currentTimeMillis()); 

        ItemModel.insert((Item) item);         
    }
}