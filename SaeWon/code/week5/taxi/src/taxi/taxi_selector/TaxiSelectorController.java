package taxi.taxi_selector;


public class TaxiSelectorController {
    private final TaxiSelectorService service;

    public TaxiSelectorController(TaxiSelectorService service) {
        this.service = service;
    }

    // POST api/taxi-select-service/taxis
    public void selectTaxi(String taxiId) {
        service.select(taxiId);
    }
}
