package components.ui.constracts;

public interface Listenable {
    public boolean isDisable();

    public boolean isClicked();

    public boolean isHovering();

    public void onHover();

    public void onClick();

    public void onWaiting();
}
