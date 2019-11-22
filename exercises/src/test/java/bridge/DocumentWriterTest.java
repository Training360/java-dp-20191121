package bridge;

import bridge.asciidoc.AsciiDocDocument;
import bridge.docbook.DocBookDocument;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DocumentWriterTest {

    @Test
    public void testAsciiDoc() throws IOException {
        StringWriter sWriter = new StringWriter();
        try (AsciiDocDocument doc = new AsciiDocDocument(sWriter)) {
            DocumentWriter docWriter = new DocumentWriter(doc);
            docWriter.writeTitle("Header 1");
            docWriter.writeParagraph("Lorem ipsum.");
            docWriter.writeTitle("Header 2");
            docWriter.writeParagraph("dolor sit amet");
            docWriter.writeParagraph("consectetur adipiscing elit");
        }

        assertThat(sWriter.toString(), containsString("= Header 1\n"));
        assertThat(sWriter.toString(), containsString("consectetur adipiscing elit\n\n"));
    }

    @Test
    public void testDocBook() throws IOException {
        StringWriter sWriter = new StringWriter();
        try (DocBookDocument doc = new DocBookDocument(sWriter)) {
            DocumentWriter docWriter = new DocumentWriter(doc);
            docWriter.writeTitle("Header 1");
            docWriter.writeParagraph("Lorem ipsum.");
            docWriter.writeTitle("Header 2");
            docWriter.writeParagraph("dolor sit amet");
            docWriter.writeParagraph("consectetur adipiscing elit");
        }

        assertThat(sWriter.toString(), containsString("<title>Header 1</title>"));
        assertThat(sWriter.toString(), containsString("<para>consectetur adipiscing elit</para>"));
        assertThat(sWriter.toString(), containsString("</article>"));

    }
}
