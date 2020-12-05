package core.UI;

public interface EventListener
{
    public void onHover();

    public void onClick();

    public void onWaiting();

    public boolean isClicked();

    public boolean isHovering();
}
