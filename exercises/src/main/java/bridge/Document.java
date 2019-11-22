package bridge;

import java.io.Closeable;

public interface Document extends Closeable {

    Title createTitle();

    Paragraph createParagraph();

}
