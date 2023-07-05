package adapter.out.persistence;

import application.port.in.ShowCurrencyQuery;
import application.port.out.ShowCurrencyDBGateway;
import domain.Currency;

public class ShowCurrencyJpaPersistenceAdapter implements ShowCurrencyDBGateway {

    private final CurrencyJpaRepository repository;

    public ShowCurrencyJpaPersistenceAdapter(CurrencyJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Currency LoadByShowCurrencyQuery(ShowCurrencyQuery query) {
        String Id = query.currencyId();
        CurrencyJpaEntity jpaEntity = repository.findByCurrencyId(Id);
        return jpaEntity.toDomainEntity();
    }
}
