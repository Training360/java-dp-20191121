package templatemethod;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Vat27MathRoundSummarize extends Summarize {

    @Override
    protected BigDecimal calculateVat(BigDecimal d) {
        return d.multiply(BigDecimal.valueOf(27.0).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
    }

    @Override
    protected BigDecimal finalRound(BigDecimal d) {
        return d.setScale(2, RoundingMode.HALF_UP);
    }
}
