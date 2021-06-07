package components.ui.radio.character.selection;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import app.cache.GameCache;
import components.ui.radio.Radio;

public abstract class CharacterSelectionRadio extends Radio {

    protected BufferedImage innerImage;

    protected BufferedImage characterImage;

    public CharacterSelectionRadio(int column, int row, int left, int right, int top, int bottom) {
        super(column, row, left, right, top, bottom);

        clickedId = 0;
    }

    @Override
    public void onWaiting() {
        currentFrame = frames.get(0);
    }

    @Override
    public void onHover() {
        currentFrame = frames.get(1);
    }

    @Override
    public void onClick() {
        clickedId = id;
        GameCache.push("selected-player", value);

        currentFrame = frames.get(1);

        sharedElements.get("character-image").setCurrentFrame(characterImage);
        sharedElements.get("character-name").setValue(value);
    }

    @Override
    public void tick() {
        if (clickedId != id) {
            super.tick();
        } else {
            onClick();
        }
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);

        graphics.drawImage(innerImage, x + 7, y + 7, 86, 86, null);
    }
}
