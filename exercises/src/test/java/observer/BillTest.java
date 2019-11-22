package observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillTest {

    @Test
    public void testEmpty() {
        Bill bill = new Bill();
        assertEquals(0, bill.getSum());
    }

    @Test
    public void testAdd() {
        Bill bill = new Bill();
        bill.addBillItem(new BillItem(10));
        assertEquals(10, bill.getSum());
    }

    @Test
    public void testAddItems() {
        Bill bill = new Bill();
        bill.addBillItem(new BillItem(10));
        bill.addBillItem(new BillItem(20));
        assertEquals(30, bill.getSum());
    }

    @Test
    public void testChangeItem() {
        Bill bill = new Bill();
        bill.addBillItem(new BillItem(10));
        bill.addBillItem(new BillItem(20));
        bill.getBillItemAt(1).setPrice(10);
        assertEquals(20, bill.getSum());
    }

}
