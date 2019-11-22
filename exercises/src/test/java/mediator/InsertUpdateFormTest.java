package mediator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertUpdateFormTest {

    private InsertUpdateForm insertUpdateForm = new InsertUpdateForm();

    @Test
    public void testInsert() {
        assertEquals("", insertUpdateForm.getId().getValue());
        assertEquals(false, insertUpdateForm.getId().isVisible());
        assertEquals("", insertUpdateForm.getAuthor().getValue());
        assertEquals("", insertUpdateForm.getTitle().getValue());
        assertEquals("Insert", insertUpdateForm.getSubmit().getValue());
    }

    @Test
    public void testSubmitInsert() {
        insertUpdateForm.getAuthor().setValue("GoF");
        insertUpdateForm.getTitle().setValue("Design Patterns");
        Book book = insertUpdateForm.submit();

        assertEquals("GoF", book.getAuthor());
        assertEquals("Design Patterns", book.getTitle());
    }

    @Test
    public void testUpdate() {
        insertUpdateForm.toUpdate(new Book(20L, "GoF", "Design Patterns"));
        assertEquals("20", insertUpdateForm.getId().getValue());
        assertEquals(true, insertUpdateForm.getId().isVisible());
        assertEquals("GoF", insertUpdateForm.getAuthor().getValue());
        assertEquals("Design Patterns", insertUpdateForm.getTitle().getValue());
        assertEquals("Update", insertUpdateForm.getSubmit().getValue());
    }

    @Test
    public void testUpdateSubmit() {
        insertUpdateForm.toUpdate(new Book(20L, "GoF", "Design Patterns"));
        insertUpdateForm.getAuthor().setValue("Gang of Four");
        Book book = insertUpdateForm.submit();

        assertEquals("Gang of Four", book.getAuthor());
    }

    @Test
    public void testReset() {
        insertUpdateForm.toUpdate(new Book(20L, "GoF", "Design Patterns"));
        insertUpdateForm.toInsert();

        assertEquals("", insertUpdateForm.getId().getValue());
        assertEquals(false, insertUpdateForm.getId().isVisible());
        assertEquals("", insertUpdateForm.getAuthor().getValue());
        assertEquals("", insertUpdateForm.getTitle().getValue());
        assertEquals("Insert", insertUpdateForm.getSubmit().getValue());
    }
}
