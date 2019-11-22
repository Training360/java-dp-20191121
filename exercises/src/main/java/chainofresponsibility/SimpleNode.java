package chainofresponsibility;


public class SimpleNode extends Node {

    @Override
    void handleEvent(String event) {
        if (getParent() != null) {
            getParent().handleEvent(event);
        }
    }
}
