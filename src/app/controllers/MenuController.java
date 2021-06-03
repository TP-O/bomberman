package app.controllers;

import app.views.GameOverView;
import app.views.MenuView;
import app.views.PauseView;
import app.views.View;

public class MenuController {

    public View showHomeMenu() {
        View view = new MenuView();

        return view;
    }

    public View showPauseMenu() {
        View view = new PauseView();

        return view;
    }

    public View showGameOverMenu() {
        View view = new GameOverView();

        return view;
    }
}
