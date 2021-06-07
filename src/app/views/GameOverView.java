package app.views;

import java.awt.Graphics;
import java.util.ArrayList;

import components.ui.Element;
import components.ui.button.NewGameButton;
import components.ui.button.QuitButton;

public class GameOverView extends View {

    @Override
    public void buildUI() {
        elements = new ArrayList<Element>();

        // Add butons
        elements.add(new NewGameButton(6, 5, 0, 0, 5, 0));
        elements.add(new QuitButton(6, 7, 0, 0, 0, 0));
    }

    @Override
    public void reset() {
        //
    }

    @Override
    public void tick() {
        elements.forEach(element -> element.tick());
    }

    @Override
    public void render(Graphics graphics) {
        elements.forEach(element -> element.render(graphics));
    }
}
