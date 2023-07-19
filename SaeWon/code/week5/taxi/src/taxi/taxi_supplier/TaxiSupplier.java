package taxi.taxi_supplier;

import taxi.common.Taxi;
import taxi.taxi_finder.AvailableTaxiCondition;

import java.util.List;

public interface TaxiSupplier {
    List<Taxi> findAllByCondition(AvailableTaxiCondition condition);

    Taxi findById(String taxiId);

    void save(DispatchableTaxi taxi);
}
