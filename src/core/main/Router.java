package core.main;

import java.awt.Graphics;
import java.util.HashMap;

import app.view.*;

public class Router
{
    private static View currentView;

    private static HashMap<String, View> views = new HashMap<String, View>();

    public static void register(String viewName, View view)
    {
        views.put(viewName, view);
    }

    public static void redirect(String viewName)
    {
        currentView = views.get(viewName);
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
