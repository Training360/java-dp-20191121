package bridge;

import java.io.Closeable;
import java.io.IOException;

public class DocumentWriter implements Closeable {

    private Document document;

    public DocumentWriter(Document document) {
        this.document = document;
    }

    public void writeTitle(String title) {
        document.createTitle().setContent(title);
    }

    public void writeParagraph(String paragraph) {
        document.createParagraph().setContent(paragraph);
    }

    @Override
    public void close() throws IOException {
        document.close();
    }
}
