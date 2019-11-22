package bridge.asciidoc;

import bridge.Document;
import bridge.Paragraph;
import bridge.Title;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class AsciiDocDocument implements Document {

    private BufferedWriter writer;

    public AsciiDocDocument(Writer writer) {
        this.writer = new BufferedWriter(writer);
    }

    @Override
    public Title createTitle() {
        return new AsciiDocTitle(writer);
    }

    @Override
    public Paragraph createParagraph() {
        return new AsciiDocParagraph(writer);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
