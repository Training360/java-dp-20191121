package templatemethod;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SummarizeTest {

    private Bill bill = new Bill(Arrays.asList(
            new BillItem("Abstract factory", BigDecimal.valueOf(10.02)),
            new BillItem("Adapter", BigDecimal.valueOf(10.05)),
            new BillItem("Bridge", BigDecimal.valueOf(10.08)),
            new BillItem("Builder", BigDecimal.valueOf(10.09)),
            new BillItem("Chain of responsibility", BigDecimal.valueOf(11.00)),
            new BillItem("Command", BigDecimal.valueOf(11.02)),
            new BillItem("Composite", BigDecimal.valueOf(11.05)),
            new BillItem("Decorator", BigDecimal.valueOf(10.01)),
            new BillItem("Facade", BigDecimal.valueOf(10.02)),
            new BillItem("Factory method", BigDecimal.valueOf(10.01)),
            new BillItem("Flyweight", BigDecimal.valueOf(10.01))

    ));

    @Test
    public void testVat10HalfEventRound() {
        assertThat(bill.sum(new Vat10HalfEvenRoundSummarize()), equalTo(BigDecimal.valueOf(11.32)));
    }

    @Test
    public void testVat27MathRound() {
        assertThat(bill.sum(new Vat27MathRoundSummarize()), equalTo(BigDecimal.valueOf(30.61)));
    }

}
