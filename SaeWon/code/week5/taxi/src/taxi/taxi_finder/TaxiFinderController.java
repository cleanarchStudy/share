package taxi.taxi_finder;

import taxi.common.Taxi;

import java.util.List;

public class TaxiFinderController {
    private final TaxiFinderService service;

    public TaxiFinderController(TaxiFinderService service) {
        this.service = service;
    }

    // GET /api/taxi-find-service/taxis
    public List<Taxi> getTaxis(){
        return service.getTaxis();
    }
}
