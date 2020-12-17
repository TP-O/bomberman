package components.behaviors.collide;

public interface CollisionBehavior
{
    /**
     *            Top
     *        *--------*
     *         |______|
     *     *|--|      |--|*
     * Left |  |      |  | Right
     *      |--|______|--|
     *     *   |      |   *
     *        *--------*
     *          Bottom
     */

    public abstract boolean collied();

    public abstract boolean collideTop();

    public abstract boolean collideBottom();

    public abstract boolean collideLeft();
  
    public abstract boolean collideRight();

    public abstract void setTarget(Object obj);
}
