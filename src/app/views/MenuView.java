package app.views;

import java.awt.Graphics;
import java.util.ArrayList;

import components.ui.Element;
import components.ui.button.PlayButton;
import components.ui.button.QuitButton;
import components.ui.image.menu.MenuBackground;
import components.ui.text.menu.MenuTitle;

public class MenuView extends View {

    @Override
    public void buildUI() {
        elements = new ArrayList<Element>();

        // Add background
        elements.add(new MenuBackground(6, 6, 0, 0, 0, 0));

        // Add butons
        elements.add(new PlayButton(6, 6, 0, 0, 0, 0));
        elements.add(new QuitButton(6, 7, 0, 0, 0, 0));

        // Add text
        elements.add(new MenuTitle(6, 3, 0, 0, 0, 0));
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
