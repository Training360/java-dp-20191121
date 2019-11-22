package abstractfactory;

public interface BookIoFactory {

    BookReader createBookReader();

    BookWriter createBookWriter();
}
