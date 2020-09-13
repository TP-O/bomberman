package core.service.camera;

import core.game.Game;

public class RecordingService
{
    private Game game;

    private CameraMan cameraMan;
    
    public RecordingService(Game game)
    {
        this.game = game;
    }

    public CameraMan getService()
    {
        return cameraMan;
    }

    public RecordingService register()
    {
        cameraMan = new CameraMan(game, 0, 0);

        return this;
    }
}
