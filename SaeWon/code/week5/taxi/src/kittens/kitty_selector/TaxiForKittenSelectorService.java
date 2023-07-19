package kittens.kitty_selector;


import taxi.taxi_selector.TaxiDispatcherUsecase;
import taxi.taxi_selector.TaxiSelectValidator;
import taxi.taxi_selector.TaxiSelectorService;

public class TaxiForKittenSelectorService extends TaxiSelectorService {
    public TaxiForKittenSelectorService(TaxiSelectValidator validator, TaxiDispatcherUsecase dispatcher) {
        super(validator, dispatcher);
    }

}