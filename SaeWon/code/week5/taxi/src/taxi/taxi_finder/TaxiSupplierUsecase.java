package taxi.taxi_finder;

import taxi.common.Taxi;

import java.util.List;

public interface TaxiSupplierUsecase {
    List<Taxi> findAvailableTaxiList(AvailableTaxiCondition condition);
}
