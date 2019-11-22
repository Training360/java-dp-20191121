package bridge.asciidoc;

import bridge.Title;

import java.io.BufferedWriter;
import java.io.IOException;

public class AsciiDocTitle implements Title {

    private BufferedWriter writer;

    public AsciiDocTitle(BufferedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void setContent(String s) {
        try {
            writer.write("= ");
            writer.write(s);
            writer.write("\n\n");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
    }
}
