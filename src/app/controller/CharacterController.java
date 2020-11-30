package app.controller;

import java.util.ArrayList;
import java.util.List;

import app.model.MonsterModel;
import app.model.PlayerModel;
import core.entity.character.Character;
import core.entity.character.monster.Monster;
import core.entity.character.player.Player;

public class CharacterController
{
    public Character getPlayer()
    {
        if (PlayerModel.get() == null) {
            throw new Error("Can not find Player");
        }

        return PlayerModel.get();
    }

    public void setPlayer(Character player)
    {
        PlayerModel.set((Player) player);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Character> getMonsters()
    {
        return (ArrayList<Character>) ((ArrayList<?>) MonsterModel.all());
    }

    @SuppressWarnings("unchecked")
    public void setMonsters(List<? extends Character> monsters)
    {
        MonsterModel.insert((List<Monster>) monsters);
    }

    public void destroyMonster(Character monster)
    {
        MonsterModel.delete((Monster) monster);
    }
}
