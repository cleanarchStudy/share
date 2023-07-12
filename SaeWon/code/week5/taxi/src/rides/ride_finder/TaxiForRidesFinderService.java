package rides.ride_finder;

import taxi.taxi_finder.AvailableTaxiCondition;
import taxi.taxi_finder.TaxiFinderService;
import taxi.taxi_finder.TaxiSupplierUsecase;

import java.util.List;

public class TaxiForRidesFinderService extends TaxiFinderService {

    public TaxiForRidesFinderService(List<TaxiSupplierUsecase> suppliers, AvailableTaxiCondition condition) {
        super(suppliers, condition);
    }

}
