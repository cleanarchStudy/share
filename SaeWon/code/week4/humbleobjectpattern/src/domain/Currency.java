package domain;

import java.math.BigDecimal;

public class Currency {
    private final String currencyId;
    private final BigDecimal amount;

    public Currency(String currencyId, BigDecimal amount) {
        this.currencyId = currencyId;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
