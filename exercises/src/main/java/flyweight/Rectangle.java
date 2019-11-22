package flyweight;

import java.util.*;

public class Rectangle {

    private static final Map<Rectangle, Rectangle> CACHE =
            Collections.synchronizedMap(new HashMap<>());

    private int width;

    private int height;

    private Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Rectangle getInstance(int width, int height) {
        Rectangle rectangle = new Rectangle(width, height);
        return CACHE.computeIfAbsent(rectangle, r -> r);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (width != rectangle.width) return false;
        return height == rectangle.height;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        return result;
    }
}
