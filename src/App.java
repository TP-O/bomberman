import app.controller.GameController;

public class App
{
    public static void main(String[] args)
    {
        GameController game = new GameController(1008, 640);

        game.launch();
    }
}
 