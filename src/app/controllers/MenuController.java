package app.controllers;

import app.views.MenuView;
import app.views.View;
import core.Handler;

public class MenuController implements Controller
{
    private Handler handler;

    public MenuController(Handler handler)
    {
        this.handler = handler;
    }

    @Override
    public View createView()
    {
        View view = new MenuView(handler);

        return view;
    }
}
