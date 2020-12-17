package components.actions.display;

import java.awt.Color;
import java.awt.Graphics;
import components.entities.Entity;
import components.ui.text.Text;
import components.ui.text.character.status.HealthStatus;

public class HealthDisplay extends Display
{
    private Entity entity;

    private Text text;

    private int health = -1;

    public HealthDisplay(Entity entity)
    {
        this.entity = entity;

        text = new HealthStatus(entity.getHandler(), 0, 0, 0, 0, 0, 0);
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
                (int) (entity.getX() - entity.getHandler().getCamera().getXOffset() - 1),
                (int) (entity.getY() - entity.getHandler().getCamera().getYOffset() - 21),
                entity.getWidth() + 1,
                6);
    }

    private void displayHealth(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        graphics.fillRect(
                (int) (entity.getX() - entity.getHandler().getCamera().getXOffset()),
                (int) (entity.getY() - entity.getHandler().getCamera().getYOffset() - 20),
                (int) (entity.getWidth()*(entity.getHealth() / (float) entity.getMaxHealth())),
                5);
    }

    private void displayText(Graphics graphics)
    {
        text.setX((int) (entity.getX() - entity.getHandler().getCamera().getXOffset()));
        text.setY((int) (entity.getY() - entity.getHandler().getCamera().getYOffset() - 35));

        if (health != entity.getHealth() || health == -1) {
            text.setValue(String.valueOf(entity.getHealth()));
            health = entity.getHealth();
        }

        text.render(graphics);
    }
}
