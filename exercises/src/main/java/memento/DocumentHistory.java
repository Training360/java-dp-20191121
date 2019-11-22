package memento;

import java.util.*;

public class DocumentHistory {

    private Deque<DocumentMemento> mementos = new ArrayDeque<>();

    private Document document;

    public DocumentHistory(Document document) {
        this.document = document;
    }

    public void takeSnapshot() {
        mementos.push(document.createMemento());
    }

    public void restoreFromSnapshot() {
        document.restoreFromMemento(mementos.pop());
    }
}
