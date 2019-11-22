package decorator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ByteFilterInputStreamTest {

    @Test
    public void testFilter() throws IOException {
        InputStream is = new ByteFilterInputStream(new ByteArrayInputStream("abacda".getBytes(StandardCharsets.UTF_8)),
                i -> i != 'a');
        byte[] chars = new byte[10];
        int i = is.read(chars);
        assertThat(i, equalTo(3));
        assertThat(new String(chars, 0, 3), equalTo("bcd"));
    }
}
