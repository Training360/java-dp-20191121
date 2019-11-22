package templatemethod;

import java.math.BigDecimal;

public class BillItem {

    private String name;

    private BigDecimal price;

    public BillItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
