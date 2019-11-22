package memento;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MementoTest {

    Document document = new Document();
    DocumentHistory documentHistory = new DocumentHistory(document);

    @Before
    public void init() {
        document.setAuthors(List.of("GoF"));
        document.setTitle("Design Patterns");

        document.setParagraphs(new ArrayList<>(List.of(new Paragraph("Abstract Factory"),
                new Paragraph("Builder"))));
    }


    @Test
    public void testSaveAndRestore() {
        documentHistory.takeSnapshot();

        document.setAuthors(List.of("Gang of four"));
        document.getParagraphs().get(0).setText("Factory Method");
        document.getParagraphs().add(new Paragraph("Prototype"));

        documentHistory.restoreFromSnapshot();

        assertEquals(List.of("GoF"), document.getAuthors());
        assertEquals("Design Patterns", document.getTitle());
        assertEquals(2, document.getParagraphs().size());
        assertEquals("Abstract Factory", document.getParagraphs().get(0).getText());
    }

}
