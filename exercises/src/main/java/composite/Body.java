package composite;

import java.util.ArrayList;
import java.util.List;

public class Body implements DocumentPart {

    private List<DocumentPart> documentParts = new ArrayList<>();

    public void addDocumentPart(DocumentPart documentPart) {
        documentParts.add(documentPart);
    }

    @Override
    public List<DocumentPart> getChildren() {
        return documentParts;
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public String getContent() {
        return "";
    }

    @Override
    public String getPostfix() {
        return "";
    }
}
