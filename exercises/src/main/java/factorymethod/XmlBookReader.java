package factorymethod;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

public class XmlBookReader implements BookReader {

    @Override
    public Book readBook(Reader reader) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            return (Book) unmarshaller.unmarshal(reader);
        }
        catch (Exception e) {
            throw new IllegalStateException("Error parsing xml", e);
        }

    }
}
