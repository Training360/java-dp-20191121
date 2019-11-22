package bridge.docbook;

import bridge.Document;
import bridge.Paragraph;
import bridge.Title;

import java.io.IOException;
import java.io.Writer;

public class DocBookDocument implements Document {

    private Writer writer;

    public DocBookDocument(Writer writer) {
        this.writer = writer;
        try {
            writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<article xmlns=\"http://docbook.org/ns/docbook\" version=\"5.0\" xml:lang=\"en\">");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
    }

    @Override
    public Title createTitle() {
        return new DocBookTitle(writer);
    }

    @Override
    public Paragraph createParagraph() {
        return new DocBookParagraph(writer);
    }

    @Override
    public void close() throws IOException {
        try {
            writer.write("</article>");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
        writer.close();
    }
}
