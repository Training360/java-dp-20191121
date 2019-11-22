package factorymethod;

import java.util.List;
import java.util.Map;

public class BookReaderFactoryProvider {

    private Map<String, BookReaderFactory> bookReaderFactories =
            Map.of("csv", new CsvBookReaderFactory(), "xml", new XmlBookReaderFactory());

    public BookReaderFactory getBookReaderFactory(String fileType) {
        BookReaderFactory factory = bookReaderFactories.get(fileType);
        if (factory == null) {
            throw new IllegalArgumentException("Illegal format: " + fileType);
        }
        return factory;
    }
}
