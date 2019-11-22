package composite;

import java.util.List;

public interface DocumentPart {

    List<DocumentPart> getChildren();

    String getPrefix();

    String getContent();

    String getPostfix();
}
