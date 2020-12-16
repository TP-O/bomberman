package components.actions.collide;

public interface Collision
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

    public boolean collideTop();

    public boolean collideBottom();

    public boolean collideLeft();

    public boolean collideRight();
}
