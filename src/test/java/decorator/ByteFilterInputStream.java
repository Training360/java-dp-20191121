package decorator;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.IntPredicate;

public class ByteFilterInputStream extends InputStream {

    private InputStream target;

    private IntPredicate bytesToFilter;

    public ByteFilterInputStream(InputStream target, IntPredicate bytesToFilter) {
        this.target = target;
        this.bytesToFilter = bytesToFilter;
    }

    @Override
    public int read() throws IOException {
        int b = target.read();
        while (b != -1 && !bytesToFilter.test(b)) {
            b = target.read();
        }
        return b;
    }
}
