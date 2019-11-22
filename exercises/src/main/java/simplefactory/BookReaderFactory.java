package simplefactory;

public class BookReaderFactory {

    public BookReader reader(String fileType) {
        switch (fileType.toLowerCase()) {
            case "csv":
                return new CsvBookReader();
            case "xml":
                return new XmlBookReader();
            default:
                throw new IllegalArgumentException("Invalid file type");
        }
    }
}
