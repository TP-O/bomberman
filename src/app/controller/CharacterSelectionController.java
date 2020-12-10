package app.controller;

import app.view.CharacterView;
import app.view.View;
import core.main.Handler;

public class CharacterSelectionController extends Controller
{
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
