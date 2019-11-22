package flyweight;

import java.util.List;

public class Calculator {

    public int calculateDistances(List<Rectangle> rectangles, int width) {
        if (rectangles.size() < 2) {
            return 0;
        }
        int sum = rectangles.stream().mapToInt(r -> r.getWidth()).sum();
        if (sum > width) {
            throw new IllegalArgumentException("Not fit");
        }
        return (width - sum) / (rectangles.size() - 1);
    }

}
