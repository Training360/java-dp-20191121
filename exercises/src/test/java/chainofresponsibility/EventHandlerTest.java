package chainofresponsibility;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EventHandlerTest {

    @Test
    public void handleEvent() {
        HandlerNode root = new HandlerNode();
        SimpleNode s1 = new SimpleNode();
        root.addChild(s1);
        HandlerNode s2 = new HandlerNode();
        root.addChild(s2);
        HandlerNode s11 = new HandlerNode();
        s1.addChild(s11);
        SimpleNode s21 = new SimpleNode();
        s2.addChild(s21);
        SimpleNode s22 = new SimpleNode();
        s2.addChild(s22);

        s1.handleEvent("event0");
        s11.handleEvent("event1");
        s11.handleEvent("event2");
        assertThat(s11.getEvents(), equalTo(Arrays.asList("event1", "event2")));
        assertThat(root.getEvents(), equalTo(Arrays.asList("event0")));


        s2.handleEvent("event3");
        s21.handleEvent("event4");
        s22.handleEvent("event5");
        assertThat(s2.getEvents(), equalTo(Arrays.asList("event3", "event4", "event5")));
        assertThat(root.getEvents(), equalTo(Arrays.asList("event0")));

    }
}
