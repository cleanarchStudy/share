package adapter.out.persistence;

import domain.Currency;

import java.math.BigDecimal;

//@Entity
public class CurrencyJpaEntity {

    // @Id
    // @GeneratedValue
    private Long Id;
    private String currencyId;
    private BigDecimal amount;

    protected CurrencyJpaEntity() {
    }

    public Currency toDomainEntity(){
        return new Currency(currencyId, amount);
    }
}
