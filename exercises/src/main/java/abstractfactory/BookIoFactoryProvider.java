package abstractfactory;

import java.util.Map;

public class BookIoFactoryProvider {

    private Map<String, BookIoFactory> bookIoFactories = Map.of(
            "csv", new CsvBookIoFactory(),
            "xml", new XmlBookIoFactory()
    );

    public BookIoFactoryProvider() {
    }

    public BookIoFactory getBookIoFactory(String fileType) {
        BookIoFactory factory = bookIoFactories.get(fileType);
        if (factory == null) {
            throw new IllegalArgumentException("Illegal format: " + fileType);
        }
        return factory;
    }
}
