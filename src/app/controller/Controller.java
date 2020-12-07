package app.controller;

import app.view.View;
import core.main.Handler;

public abstract class Controller
{
    protected Handler handler;

    public abstract View createView();
}
