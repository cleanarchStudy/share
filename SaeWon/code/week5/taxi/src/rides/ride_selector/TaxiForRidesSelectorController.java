package rides.ride_selector;


import taxi.taxi_selector.TaxiSelectorController;
import taxi.taxi_selector.TaxiSelectorService;

public class TaxiForRidesSelectorController extends TaxiSelectorController {

    public TaxiForRidesSelectorController(TaxiSelectorService service) {
        super(service);
    }

    //핸들링할 Path 정보 추가 "POST /api/taxi-for-rides-select-service/taxis"
}
