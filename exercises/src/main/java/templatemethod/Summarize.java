package templatemethod;

import java.math.BigDecimal;

public abstract class Summarize {

    public BigDecimal sum(Bill bill) {
        return finalRound(bill.getBillItems()
                .stream()
                .map(BillItem::getPrice)
                .map(this::calculateVat)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    protected abstract BigDecimal calculateVat(BigDecimal d);

    protected abstract BigDecimal finalRound(BigDecimal d);

}
