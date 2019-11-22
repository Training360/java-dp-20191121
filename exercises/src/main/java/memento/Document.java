package memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Document {

    private List<String> authors = new ArrayList<>();

    private String title;

    private List<Paragraph> paragraphs = new ArrayList<>();

    public Document() {
    }

    DocumentMemento createMemento() {
        List<String> copiedAuthors = Collections.unmodifiableList(new ArrayList<>(authors));
        List<Paragraph> copiedParagraphs =
                Collections.unmodifiableList(paragraphs.stream().map(Paragraph::new).collect(Collectors.toList()));
        DocumentMemento memento = new DocumentMemento(copiedAuthors, title, copiedParagraphs);
        return memento;

    }

    public void restoreFromMemento(DocumentMemento memento) {
        authors = new ArrayList<>(memento.getAuthors());
        title = memento.getTitle();
        paragraphs = new ArrayList<>(memento.getParagraphs().stream().map(Paragraph::new).collect(Collectors.toList()));
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }


}
