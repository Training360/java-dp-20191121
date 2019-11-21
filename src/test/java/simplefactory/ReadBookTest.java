package simplefactory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReadBookTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testReadCsv() {
        Book book = new BookReaderFactory()
                .reader("csv")
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.csv"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }

    @Test
    public void testReadXml() {
        Book book = new BookReaderFactory()
                .reader("xml")
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.xml"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }

    @Test
    public void testReadUnknownFileType() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid file type");

        new BookReaderFactory().reader("json");
    }
}
