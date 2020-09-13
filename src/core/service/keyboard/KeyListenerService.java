package core.service.keyboard;

import core.game.Game;

public class KeyListenerService
{
    private Game game;

    private KeyManager keyManager;

    public KeyListenerService(Game game)
    {
        this.game = game;
        this.keyManager = new KeyManager();
    }

    public KeyManager getService()
    {
        return keyManager;
    }

    public KeyListenerService register()
    {
        game.getDisplay().getFrame().addKeyListener(keyManager);

        return this;
    }
}
