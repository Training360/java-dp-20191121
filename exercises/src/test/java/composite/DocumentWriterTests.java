package composite;

import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class DocumentWriterTests {

    @Test
    public void write() {
        Document document = new Document();
        document.getHeader().addEntry("header1", "value1");
        document.getHeader().addEntry("header2", "value2");


        Title title = new Title("Title 1");
        document.getBody().addDocumentPart(title);
        Paragraph paragraph = new Paragraph("Lorem ipsum");
        document.getBody().addDocumentPart(paragraph);

        StringWriter sWriter = new StringWriter();
        new DocumentWriter().write(document, sWriter);
        assertThat(sWriter.toString(), containsString("---\nheader1: value1"));
        assertThat(sWriter.toString(), containsString("# Title 1\n"));
        assertThat(sWriter.toString(), containsString("Lorem ipsum\n"));
    }
}
