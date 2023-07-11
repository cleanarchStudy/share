package kittens.kitty_finder;

import taxi.taxi_finder.TaxiFinderController;
import taxi.taxi_finder.TaxiFinderService;

public class TaxiForKittenController extends TaxiFinderController {

    public TaxiForKittenController(TaxiFinderService service) {
        super(service);
    }

    //핸들링할 Path 정보 추가 "GET /api/taxi-for-kittens-find-service/taxis"
}
