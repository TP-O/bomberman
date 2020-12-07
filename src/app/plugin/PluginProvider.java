package app.plugin;

import app.plugin.camera.Camera;
import app.plugin.keyboard.KeyBoard;
import app.plugin.mouse.Mouse;
import core.main.Handler;

public class PluginProvider
{
    private Handler handler;

    public Camera camera;

    public KeyBoard keyBoard;

    public Mouse mouse;

    public PluginProvider(Handler handler)
    {
        this.handler = handler;
    }

    public void plug()
    {
        keyBoard = new KeyBoard();
        camera = new Camera();
        mouse = new Mouse();

        keyBoard.plug(handler);
        camera.plug(handler);
        mouse.plug(handler);
    }
}
