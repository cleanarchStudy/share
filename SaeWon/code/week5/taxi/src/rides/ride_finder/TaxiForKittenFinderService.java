package rides.ride_finder;

import taxi.taxi_finder.AvailableTaxiCondition;
import taxi.taxi_finder.TaxiFinderService;
import taxi.taxi_finder.TaxiSupplierUsecase;

import java.util.List;

public class TaxiForKittenFinderService extends TaxiFinderService {

    public TaxiForKittenFinderService(List<TaxiSupplierUsecase> suppliers, AvailableTaxiCondition condition) {
        super(suppliers, condition);
    }

}
