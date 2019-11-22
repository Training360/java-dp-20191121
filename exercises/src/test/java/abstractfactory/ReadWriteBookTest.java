package abstractfactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReadWriteBookTest {

    private BookIoFactoryProvider bookIoFactoryProvider = new BookIoFactoryProvider();

    @Test
    public void testReadCsv() {
        Book book = bookIoFactoryProvider
                .getBookIoFactory("csv")
                .createBookReader()
                .readBook(new InputStreamReader(ReadWriteBookTest.class.getResourceAsStream("book.csv"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }

    @Test
    public void testReadXml() {
        Book book = bookIoFactoryProvider
                .getBookIoFactory("xml")
                .createBookReader()
                .readBook(new InputStreamReader(ReadWriteBookTest.class.getResourceAsStream("book.xml"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }

    @Test
    public void testWriteCsv() {
        StringWriter writer = new StringWriter();
        bookIoFactoryProvider
                .getBookIoFactory("csv")
                .createBookWriter()
                .writeBook(new Book("Erich Gamma", "Design Patterns"), writer);
        assertThat(writer.toString(), equalTo("Erich Gamma;Design Patterns"));
    }

    @Test
    public void testWriteXml() {
        StringWriter writer = new StringWriter();
        bookIoFactoryProvider
                .getBookIoFactory("xml")
                .createBookWriter()
                .writeBook(new Book("Erich Gamma", "Design Patterns"), writer);
        assertThat(writer.toString(), equalTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book><authors>Erich Gamma</authors><title>Design Patterns</title></book>"));
    }
}
