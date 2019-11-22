package bridge.docbook;

import bridge.Paragraph;

import java.io.IOException;
import java.io.Writer;

public class DocBookParagraph implements Paragraph {

    private Writer writer;

    public DocBookParagraph(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void setContent(String s) {
        try {
            writer.write("<para>");
            writer.write(s);
            writer.write("</para>");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
    }
}
