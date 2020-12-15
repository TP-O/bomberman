package app.controllers;

import app.views.CharacterView;
import app.views.View;
import core.Handler;

public class CharacterSelectionController implements Controller
{
    private Handler handler;

    public CharacterSelectionController(Handler handler)
    {
        this.handler = handler;
    }

    @Override
    public View createView()
    {
        View view = new CharacterView(handler);

        return view;
    }
}
