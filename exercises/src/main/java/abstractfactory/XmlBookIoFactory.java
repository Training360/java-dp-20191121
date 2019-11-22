package abstractfactory;

public class XmlBookIoFactory implements BookIoFactory {

    @Override
    public BookReader createBookReader() {
        return new XmlBookReader();
    }

    @Override
    public BookWriter createBookWriter() {
        return new XmlBookWriter();
    }

}
