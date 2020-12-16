package app.listeners;

import components.entities.dynamic.character.monster.Monster;

public class KilledMonsterListener implements Listener
{
    private Monster monster;
    
    public KilledMonsterListener(Monster monster)
    {
        this.monster = monster;
    }

    @Override
    public void handle()
    {
        //
    }
}
