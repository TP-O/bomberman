package components.entities.dynamics;

import java.util.ArrayList;
import java.util.List;

import java.awt.image.BufferedImage;

import components.actions.move.Move;
import components.actions.move.MoveAction;
import components.entities.Entity;

public abstract class DynamicEntity extends Entity {

    protected Move move;

    protected List<BufferedImage> upFrames;

    protected List<BufferedImage> downFrames;

    protected List<BufferedImage> leftFrames;

    protected List<BufferedImage> rightFrames;

    protected List<BufferedImage> standFrames;

    @Override
    protected void loadAllFrames() {
        // Create empty frame lists
        upFrames = new ArrayList<BufferedImage>();
        downFrames = new ArrayList<BufferedImage>();
        leftFrames = new ArrayList<BufferedImage>();
        rightFrames = new ArrayList<BufferedImage>();
        standFrames = new ArrayList<BufferedImage>();
    }

    @Override
    protected void initializeActions() {
        move = new MoveAction(this);
    }

    @Override
    public void tick() {
        // Move
        move.move();
    }

    public Move getMove() {
        return move;
    }

    public List<BufferedImage> getUpFrames()
    {
        return upFrames;
    }

    public List<BufferedImage> getDownFrames() {
        return downFrames;
    }

    public List<BufferedImage> getLeftFrames() {
        return leftFrames;
    }

    public List<BufferedImage> getRightFrames() {
        return rightFrames;
    }

    public List<BufferedImage> getStandFrames() {
        return standFrames;
    }
}
