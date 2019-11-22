package abstractfactory;

import java.io.*;

public class CsvBookWriter implements BookWriter {

    @Override
    public void writeBook(Book book, Writer w) {
        try (BufferedWriter writer = new BufferedWriter(w)) {
            writer.write(book.getAuthors() + ";" + book.getTitle());
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Error writing file", ioe);
        }
    }
}
