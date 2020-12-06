package ui;

public interface Sharable
{
    public Element getSharedElement();

    public void receiveElement(Element element);

    public void shareWith(Element element);
}
