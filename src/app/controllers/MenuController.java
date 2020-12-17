package app.controllers;

import app.views.MenuView;
import app.views.View;

public class MenuController
{
    public View showHomeMenu()
    {
        View view = new MenuView();

        return view;
    }
}
