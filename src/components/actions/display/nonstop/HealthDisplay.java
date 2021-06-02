package components.actions.display.nonstop;

import java.awt.Color;
import java.awt.Graphics;

import components.actions.display.Display;
import components.actions.display.DisplayDecorator;
import components.ui.text.Text;
import components.ui.text.character.status.HealthStatus;
import core.Handler;

public class HealthDisplay extends DisplayDecorator {

    private Text text;

    private int health;

    private Handler handler;

    public HealthDisplay(Display display) {
        super(display);

        health = -1;
        handler = Handler.getInstance();
        text = new HealthStatus(0, 0, 0, 0, 0, 0);
    }

    @Override
    public void decorate(Graphics graphics) {
        displayBox(graphics);
        displayHealth(graphics);
        displayText(graphics);
    }

    private void displayBox(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRect(
                (int) (getEntity().getX() - handler.getCamera().getXOffset() - 1),
                (int) (getEntity().getY() - handler.getCamera().getYOffset() - 21),
                getEntity().getWidth() + 1,
                6);
    }

    private void displayHealth(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(
                (int) (getEntity().getX() - handler.getCamera().getXOffset()),
                (int) (getEntity().getY() - handler.getCamera().getYOffset() - 20),
                (int) (getEntity().getWidth()*(getEntity().getHealth() / (float) getEntity().getLife())),
                5);
    }

    private void displayText(Graphics graphics) {
        text.setX((int) (getEntity().getX() - handler.getCamera().getXOffset()));
        text.setY((int) (getEntity().getY() - handler.getCamera().getYOffset() - 35));

        if (health != getEntity().getHealth() || health == -1) {
            text.setValue(String.valueOf(getEntity().getHealth()));
            health = getEntity().getHealth();
        }

        text.render(graphics);
    }
}
