package observer;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private List<BillItem> billItems = new ArrayList<>();

    private int sum;

    public void addBillItem(BillItem billItem) {
        billItems.add(billItem);
        sum += billItem.getPrice();
        billItem.onChange(e -> sum += e.getDiff());
    }

    public int numberOfBillItems() {
        return billItems.size();
    }

    public BillItem getBillItemAt(int i) {
        return billItems.get(i);
    }

    public int getSum() {
        return sum;
    }
}
