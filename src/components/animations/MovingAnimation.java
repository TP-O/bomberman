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

        this.entity.setCurrentFrame(this.frames.get(getIndex()));
    }

    public void up() {
        if (!this.up) {

            this.up = true;
            this.down = this.left = this.right = false;

            this.setFrames(this.entity.getUpFrames());
        }
    }

    public void down() {
        if (!this.down) {
            this.down = true;
            this.up = this.left = this.right = false;

            this.setFrames(this.entity.getDownFrames());
        }
    }

    public void left() {
        if (!this.left) {
            this.left = true;
            this.up = this.down = this.right = false;

            this.setFrames(this.entity.getLeftFrames());
        }
    }

    public void right() {
        if (!this.right) {
            this.right = true;
            this.up = this.down = this.left = false;

            this.setFrames(this.entity.getRightFrames());
        }
    }

    public void stand() {
        if (this.up || this.down || this.left || this.right) {
            this.up = this.down = this.left = this.right = false;

            this.setFrames(this.entity.getStandFrames());
        }
    }
}
