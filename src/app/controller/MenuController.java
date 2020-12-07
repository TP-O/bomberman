package app.controller;

import java.util.ArrayList;

import app.view.MenuView;
import app.view.View;
import core.main.Handler;
import ui.Element;
import ui.button.PlayButton;
import ui.button.QuitButton;
import ui.image.HomeBackground;

public class MenuController extends Controller
{
    public MenuController(Handler handler)
    {
        this.handler = handler;
    }

    @Override
    public View createView()
    {
        ArrayList<Element> elements = new ArrayList<Element>();

        // Add background
        elements.add(new HomeBackground(handler, 0.5f, 0.5f, 0, 0));

        // Add butons
        elements.add(new PlayButton(handler, 0.5f, 0.5f, 0, 0));
        elements.add(new QuitButton(handler, 0.5f, 0.6f, 0, 0));
      
        View view = new MenuView(handler, elements);

        return view;
    }
}
