package templatemethod;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Vat10HalfEvenRoundSummarize extends Summarize  {

    @Override
    protected BigDecimal calculateVat(BigDecimal d) {
        return d.multiply(BigDecimal.valueOf(10.0)).divide(BigDecimal.valueOf(100.0), 2, RoundingMode.HALF_EVEN);
    }

    @Override
    protected BigDecimal finalRound(BigDecimal d) {
        return d.setScale(2, RoundingMode.HALF_UP);
    }
}
