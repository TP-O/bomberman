package components.ui.constracts;

import components.ui.Element;

public interface Sharable {
    public void receive(String name, Element element);

    public void shareWith(String name, Element element);

    public Element getSharedElement(String name);
}
