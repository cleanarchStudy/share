package rides.ride_finder;

import taxi.taxi_finder.TaxiFinderController;
import taxi.taxi_finder.TaxiFinderService;

public class TaxiForRidesController extends TaxiFinderController {

    public TaxiForRidesController(TaxiFinderService service) {
        super(service);
    }

    //핸들링할 Path 정보 추가 "GET /api/taxi-for-rides-find-service/taxis"
}
