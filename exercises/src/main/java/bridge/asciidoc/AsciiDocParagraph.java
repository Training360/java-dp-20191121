package bridge.asciidoc;

import bridge.Paragraph;

import java.io.BufferedWriter;
import java.io.IOException;

public class AsciiDocParagraph implements Paragraph {

    private BufferedWriter writer;

    public AsciiDocParagraph(BufferedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void setContent(String s) {
        try {
            writer.write(s);
            writer.write("\n\n");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
    }

}
