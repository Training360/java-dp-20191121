package abstractfactory;

import java.io.Writer;

public interface BookWriter {

    void writeBook(Book book, Writer w);
}
