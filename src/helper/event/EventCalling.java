package helper.event;

import app.events.Event;

public class EventCalling {

    public static void event(Event event) {
        event.emit();
    }
}
