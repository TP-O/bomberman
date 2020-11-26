package core.state;

import java.awt.Graphics;
import app.controller.GameController;

public class MenuState extends State
{
    public MenuState(GameController gameController)
    {
        super(gameController);
    }

    public void tick()
    {
        System.out.println(gameController.getMouseService().mouseX);
    }    

    public void render(Graphics graphics)
    {
        //
    }
}
