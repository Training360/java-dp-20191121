package abstractfactory;

public class CsvBookIoFactory implements BookIoFactory {

    @Override
    public BookReader createBookReader() {
        return new CsvBookReader();
    }

    @Override
    public BookWriter createBookWriter() {
        return new CsvBookWriter();
    }
}
