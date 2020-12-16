package core;

import java.awt.Graphics;
import java.util.HashMap;

import app.controllers.Controller;
import app.views.*;

public class Router
{
    private static View currentView;

    private static HashMap<String, Controller> controllers = new HashMap<String, Controller>();

    public static void register(String viewName, Controller controller)
    {
        controllers.put(viewName, controller);
    }

    public static void redirect(String viewName)
    {
        currentView = controllers.get(viewName).createView();
    }

    public static void tick()
    {
        if (currentView == null) {
            throw new Error("Can't find view");
        }
        currentView.tick();
    }

    public static void render(Graphics graphics)
    {
        if (currentView == null) {
            throw new Error("Can't find view");
        }
        currentView.render(graphics);
    }   
}
