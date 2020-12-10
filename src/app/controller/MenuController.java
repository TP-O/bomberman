package app.controller;

import app.view.MenuView;
import app.view.View;
import core.main.Handler;


public class MenuController extends Controller
{
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
