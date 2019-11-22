package observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillItemTest {

    private int diff;

    @Test
    public void testAccess() {
        BillItem billItem = new BillItem(10);
        billItem.onChange(e -> diff = e.getDiff());
        billItem.setPrice(20);
        assertEquals(10, diff);
    }
}
