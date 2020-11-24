package core.entity.character;

import java.awt.Graphics;
import core.asset.Asset;
import app.controller.GameController;
import core.asset.Animation;
import java.awt.image.BufferedImage;


public class Player extends Character
{
    //Animations
    private Animation aniDown, aniUp, aniLeft, aniRight, aniStand;                     
    private float xMove, yMove;

    public Player(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(gameController , x, y, width, height, health, damage, speed, Asset.player_stand);
        aniDown = new Animation(500, Asset.player_down);
        aniUp = new Animation(500, Asset.player_up);
        aniLeft = new Animation(500, Asset.player_left);
        aniRight = new Animation(500, Asset.player_right);
        aniStand = new Animation(500, Asset.player_stand);
     
    }

    public void tick()
    {
        aniDown.tick(); 
        aniUp.tick();
        aniLeft.tick();
        aniRight.tick();
        aniStand.tick();
        
        xMove = 0;
        yMove = 0;

        if (gameController.getKeyService().up.pressed) {
            moveUp(speed);
            yMove = -speed;
        }

        if (gameController.getKeyService().down.pressed) {
            moveDown(speed);
            yMove = speed;
        }

        if (gameController.getKeyService().left.pressed) {
            moveLeft(speed);
            xMove = -speed;
        }
        
        if (gameController.getKeyService().right.pressed) {
            moveRight(speed);
            xMove = speed;
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(getCurrentAnimationFrame(),
            (int) (x - gameController.getCameraService().getXOffset()),
            (int) (y - gameController.getCameraService().getYOffset()),
            width, height, null);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (xMove < 0) {
            return aniLeft.getCurrentFrame();
        }else if (xMove > 0) {
            return aniRight.getCurrentFrame();
        }else if (yMove < 0) {
            return aniUp.getCurrentFrame();
        }else if (yMove > 0) {
            return aniDown.getCurrentFrame();
        }else {
            return aniStand.getCurrentFrame();
        }
    }
}
