package app.events;

import app.listeners.KilledMonsterListener;
import app.listeners.Listener;
import components.entities.dynamic.character.monster.Monster;

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
