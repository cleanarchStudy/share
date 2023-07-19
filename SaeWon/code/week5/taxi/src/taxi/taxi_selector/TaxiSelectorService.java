package taxi.taxi_selector;


public abstract class TaxiSelectorService {

    private final TaxiSelectValidator validator;
    private final TaxiDispatcherUsecase dispatcher;

    public TaxiSelectorService(TaxiSelectValidator validator, TaxiDispatcherUsecase dispatcher) {
        this.validator = validator;
        this.dispatcher = dispatcher;
    }

    public void select(String taxiId) {
        validator.validate(taxiId);
        dispatcher.dispatch(taxiId);
    }
}