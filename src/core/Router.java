package core;

import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import app.views.*;
import config.AppConfig;

public class Router {

    private static Router instance;

    private View currentView;

    private HashMap<String, View> views = new HashMap<String, View>();

    private HashMap<String, String> inputs = new HashMap<String, String>();

    private Router() {
        //
    }

    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }

        return instance;
    }

    public void register(String viewName, String input) {
        inputs.put(viewName, input);
    }

    public void redirect(String viewName, boolean refresh) {
        if (views.get(viewName) == null || refresh == true) {
            views.put(viewName, handle(inputs.get(viewName)));
        }

        currentView = views.get(viewName);
    }

    @SuppressWarnings("all")
    public View handle(String path) {
        try {
            // Get names of controller and method
            String[] parts = path.split("@");

            // Load controller
            Class controller = Class.forName(AppConfig.CONTROLLER_PREFIX + "." + parts[0]);

            // Load method
            Method method = controller.getMethod(parts[1]);

            // Execute method
            View view = (View) (method.invoke(controller.getConstructor().newInstance()));

            return view;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void tick() {
        if (currentView == null) {
            throw new Error("Can't find view");
        }

        currentView.tick();
    }

    public void render(Graphics graphics) {
        if (currentView == null) {
            throw new Error("Can't find view");
        }

        currentView.render(graphics);
    }
}
