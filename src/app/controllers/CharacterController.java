package app.controllers;

import app.views.CharacterView;
import app.views.View;
import core.Handler;

public class CharacterController implements Controller
{
    private Handler handler;

    public CharacterController(Handler handler)
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
