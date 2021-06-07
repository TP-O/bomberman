package components.animations;

import components.entities.dynamics.DynamicEntity;

public class MovingAnimation extends Animation {

    private boolean up;

    private boolean down;

    private boolean left;

    private boolean right;

    private DynamicEntity entity;

    public MovingAnimation(DynamicEntity entity, int speed) {
        super(speed);

        this.entity = entity;
        this.setFrames(entity.getStandFrames());
    }

    @Override
    public void tick() {
        super.tick();

        entity.setCurrentFrame(frames.get(getIndex()));
    }

    public void up() {
        if (!up) {

            up = true;
            down = left = right = false;

            setFrames(entity.getUpFrames());
        }
    }

    public void down() {
        if (!down) {
            down = true;
            up = left = right = false;

            setFrames(entity.getDownFrames());
        }
    }

    public void left() {
        if (!left) {
            left = true;
            up = down = right = false;

            setFrames(entity.getLeftFrames());
        }
    }

    public void right() {
        if (!right) {
            right = true;
            up = down = left = false;

            setFrames(entity.getRightFrames());
        }
    }

    public void stand() {
        if (up || down || left || right) {
            up = down = left = right = false;

            setFrames(entity.getStandFrames());
        }
    }
}
