package flyweight;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testComputeIfEmpty() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculateDistances(Collections.emptyList(), 200), equalTo(0));
        assertThat(calculator.calculateDistances(Arrays.asList(Rectangle.getInstance(100, 20)), 200),
                equalTo(0));
    }

    @Test
    public void testComputeIfNotFit() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Not fit");

        new Calculator().calculateDistances(Arrays.asList(Rectangle.getInstance(100, 100),
                Rectangle.getInstance(100, 20)), 50);
    }

    @Test
    public void testCompute() {
        assertThat(new Calculator().calculateDistances(Arrays.asList(Rectangle.getInstance(100, 100),
                Rectangle.getInstance(100, 20)), 220), equalTo(20));
    }

    @Test
    public void testComputeMore() {
        List<Rectangle> rectangles = IntStream
                .range(0, 100)
                .mapToObj(i -> Rectangle.getInstance(10, 5))
                .collect(Collectors.toList());
        assertThat(new Calculator().calculateDistances(rectangles, 1200), equalTo(2));
    }
}
