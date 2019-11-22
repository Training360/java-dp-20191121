package memento;

import java.util.ArrayList;
import java.util.List;

public class DocumentMemento {

    private List<String> authors;

    private String title;

    private List<Paragraph> paragraphs;

    public DocumentMemento(List<String> authors, String title, List<Paragraph> paragraphs) {
        this.authors = authors;
        this.title = title;
        this.paragraphs = paragraphs;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
}
