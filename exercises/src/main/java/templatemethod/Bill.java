package templatemethod;

import java.math.BigDecimal;
import java.util.List;

public class Bill {

    private List<BillItem> billItems;

    public Bill(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public BigDecimal sum(Summarize summarize) {
        return summarize.sum(this);
    }
}
