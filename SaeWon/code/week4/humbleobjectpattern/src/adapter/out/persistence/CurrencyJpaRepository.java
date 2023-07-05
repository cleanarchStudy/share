package adapter.out.persistence;



public interface CurrencyJpaRepository
// extends JpaRepository<Currency, Long>
{
    CurrencyJpaEntity findByCurrencyId(String id);
}
