package components.actions.display;

import java.awt.Color;
import java.awt.Graphics;
import components.entities.Entity;
import components.ui.text.Text;
import components.ui.text.character.status.HealthStatus;
import core.Handler;

public class HealthDisplay implements Display
{
    private Handler handler;

    private Entity entity;

    private Text text;

    public HealthDisplay(Handler handler, Entity entity)
    {
        this.handler = handler;
        this.entity = entity;

        text = new HealthStatus(handler, 0, 0, 0, 0, 0, 0);
    }

    @Override
    public void display(Graphics graphics)
    {
        displayBox(graphics);
        displayHealth(graphics);
        displayText(graphics);
    }

    private void displayBox(Graphics graphics)
    {
        graphics.setColor(Color.WHITE);
        graphics.drawRect(
                (int) (entity.getX() - handler.getCamera().getXOffset() - 1),
                (int) (entity.getY() - handler.getCamera().getYOffset() - 21),
                entity.getWidth() + 1,
                6);
    }

    private void displayHealth(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        graphics.fillRect(
                (int) (entity.getX() - handler.getCamera().getXOffset()),
                (int) (entity.getY() - handler.getCamera().getYOffset() - 20),
                (int) (entity.getWidth()*(entity.getHealth() / 100.0)),
                5);
    }

    private void displayText(Graphics graphics)
    {
        text.setX((int) (entity.getX() - handler.getCamera().getXOffset()));
        text.setY((int) (entity.getY() - handler.getCamera().getYOffset() - 35));
        text.setValue(String.valueOf(entity.getHealth()));

        text.render(graphics);
    }
}
