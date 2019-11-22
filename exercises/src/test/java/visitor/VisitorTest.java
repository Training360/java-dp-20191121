package visitor;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VisitorTest {

    @Test
    public void testUpperCaseVisitor() {
        Document document = new Document();
        Title title = new Title("Header 1");
        document.addItem(title);
        Paragraph paragraph = new Paragraph("Lorem ipsum.");
        document.addItem(paragraph);
        Title title2 = new Title("Header 2");
        document.addItem(title2);
        Paragraph paragraph2 = new Paragraph("dolor sit amet");
        document.addItem(paragraph2);

        UpperCaseItemVisitor upperCaseItemVisitor = new UpperCaseItemVisitor();
        document.visit(upperCaseItemVisitor);

        assertThat(((Title) document.getChildren().get(0)).getText(), equalTo("HEADER 1"));
        assertThat(((Paragraph) document.getChildren().get(3)).getText(), equalTo("DOLOR SIT AMET"));

    }
}
