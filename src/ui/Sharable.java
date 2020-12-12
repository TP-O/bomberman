package ui;

public interface Sharable
{
    public void receive(String name, Element element);

    public void shareWith(String name, Element element);

    public Element getSharedElement(String name);
}
