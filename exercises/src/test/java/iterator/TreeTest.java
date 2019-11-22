package iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TreeTest {

    @Test
    public void testIterator() {
        Tree<String> tree = new Tree<>();
        tree.createRoot("a");
        tree.addChild("a", "a1");
        tree.addChild("a", "a2");
        tree.addChild("a1", "a11");
        tree.addChild("a1", "a12");

        List<String> l = new ArrayList<>();
        Iterator<String> i = tree.iterator();
        while (i.hasNext()) {
            l.add(i.next());
        }

        assertThat(l, equalTo(Arrays.asList("a", "a1", "a11", "a12", "a2")));
    }
}
