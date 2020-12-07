package helper.event;

import app.event.event.Event;

public class EventCalling
{
    public static void event(Event event)
    {
        event.emit();
    }
}
