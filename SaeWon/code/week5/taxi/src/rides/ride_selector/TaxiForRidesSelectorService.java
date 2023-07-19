package rides.ride_selector;


import taxi.taxi_selector.TaxiDispatcherUsecase;
import taxi.taxi_selector.TaxiSelectValidator;
import taxi.taxi_selector.TaxiSelectorService;

public class TaxiForRidesSelectorService extends TaxiSelectorService {
    public TaxiForRidesSelectorService(TaxiSelectValidator validator, TaxiDispatcherUsecase dispatcher) {
        super(validator, dispatcher);
    }

}