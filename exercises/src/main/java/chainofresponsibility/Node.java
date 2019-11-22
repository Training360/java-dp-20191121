package chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    private Node parent;

    private List<Node> children = new ArrayList<>();

    abstract void handleEvent(String event);

    public void addChild(Node node) {
        children.add(node);
        node.parent = this;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }
}
