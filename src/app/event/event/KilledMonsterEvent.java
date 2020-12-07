package app.event.event;

import entity.character.monster.Monster;
import app.event.listener.KilledMonsterListener;
import app.event.listener.Listener;

public class KilledMonsterEvent implements Event
{
    private Listener listener;

    public KilledMonsterEvent(Monster monster)
    {
        listener = new KilledMonsterListener(monster);
    }

    @Override
    public void emit()
    {
        listener.handle();
    }
}
