package app.event.event;

import app.event.listener.KilledMonsterListener;
import app.event.listener.Listener;
import entity.item.Item;

public class KilledMonsterEvent implements Event
{
    private Listener listener;

    public KilledMonsterEvent(Item item, float x, float y)
    {
        listener = new KilledMonsterListener(item, x, y);
    }

    @Override
    public void emit()
    {
        listener.handle();
    }
}
