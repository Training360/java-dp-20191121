package flyweight;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class RectangleTest {

    @Test
    public void create() {
        Rectangle r1 = Rectangle.getInstance(100, 200);
        assertThat(r1.getWidth(), equalTo(100));
        assertThat(r1.getHeight(), equalTo(200));

        Rectangle r2 = Rectangle.getInstance(100, 200);
        assertThat(r1, sameInstance(r2));
    }
}
