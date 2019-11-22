package chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class HandlerNode extends Node {

    private List<String> events = new ArrayList<>();

    @Override
    void handleEvent(String event) {
        events.add(event);
    }

    public List<String> getEvents() {
        return events;
    }
}
