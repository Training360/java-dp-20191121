package bridge.docbook;

import bridge.Title;

import java.io.IOException;
import java.io.Writer;

public class DocBookTitle implements Title {

    private Writer writer;

    public DocBookTitle(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void setContent(String s) {
        try {
            writer.write("<title>");
            writer.write(s);
            writer.write("</title>");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
    }
}
