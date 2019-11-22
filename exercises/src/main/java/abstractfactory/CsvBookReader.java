package abstractfactory;

import java.io.BufferedReader;
import java.io.Reader;

public class CsvBookReader implements BookReader {

    @Override
    public Book readBook(Reader reader) {
        return new BufferedReader(reader).lines().findFirst().map(s -> {
            String[] parts = s.split(";");
            String authors = parts[0];
            String title = parts[1];
            return new Book(authors, title);
        }).orElseThrow(() -> new IllegalArgumentException("Invalid file"));
    }
}
