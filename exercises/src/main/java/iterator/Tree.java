package iterator;

import java.util.*;

public class Tree<T> implements Iterable<T> {

    private Node<T> root;

    public void createRoot(T value) {
        root = new Node(value);
    }

    public void addChild(T parent, T element) {
        Node<T> parentNode = findNode(root, parent)
                .orElseThrow(() -> new IllegalArgumentException("Element not found"));
        parentNode.addChild(element);
    }

    private Optional<Node<T>> findNode(Node<T> node, T element) {
        if (node.value.equals(element)) {
            return Optional.of(node);
        }
        else {
            List<Node<T>> children = node.children;
            return children.stream().map(n -> findNode(n, element)).filter(Optional::isPresent).findFirst().orElse(Optional.empty());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter<>(root);
    }

    private static class Iter<T> implements Iterator<T> {

        List<Node<T>> nodes = new ArrayList<>();

        private int index = 0;

        public Iter(Node<T> root) {
            addNode(root);
        }

        public void addNode(Node<T> node) {
            nodes.add(node);
            List<Node<T>> children = node.children;
            children.stream().forEach(this::addNode);
        }

        @Override
        public boolean hasNext() {
            return index < nodes.size();
        }

        @Override
        public T next() {
            return nodes.get(index++).value;
        }
    }

    private static class Node<T> {

        private T value;

        private Node<T> parent;

        private List<Node<T>> children = new ArrayList<>();

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> parent) {
            this.value = value;
            this.parent = parent;
        }

        public void addChild(T value) {
            children.add(new Node(value, this));
        }

    }
}
