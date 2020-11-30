package app.model;

import core.entity.character.player.Player;

public class PlayerModel
{
    private static Player data;

    public static Player get()
    {
        return data;
    }

    public static void set(Player player)
    {
        data = player;
    }

    public static void delete()
    {
        data = null;
    }
}
