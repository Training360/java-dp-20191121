package composite;

import java.util.Arrays;
import java.util.List;

public class Document implements DocumentPart {

    private Header header = new Header();

    private Body body = new Body();

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }

    @Override
    public List<DocumentPart> getChildren() {
        return Arrays.asList(header, body);
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public String getContent() {
        return "";
    }

    @Override
    public String getPostfix() {
        return "";
    }
}
