package abstractfactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.OutputStream;
import java.io.Writer;

public class XmlBookWriter implements BookWriter {

    @Override
    public void writeBook(Book book, Writer w) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.marshal(book, w);
        }
        catch (Exception e) {
            throw new IllegalStateException("Error parsing xml", e);
        }
    }
}
