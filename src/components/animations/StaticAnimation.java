package components.animations;

import components.entities.statics.StaticEntity;

public class StaticAnimation extends Animation {

    private StaticEntity entity;

    public StaticAnimation(StaticEntity entity, int speed) {
        super(speed);

        this.entity = entity;
        this.setFrames(entity.getFrames());
    }

    @Override
    public void tick() {
        super.tick();

        entity.setCurrentFrame(frames.get(getIndex()));
    }
}
