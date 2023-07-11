package kittens.kitty_selector;


import taxi.taxi_selector.TaxiSelectorController;
import taxi.taxi_selector.TaxiSelectorService;
public class TaxiForKittenSelectorController extends TaxiSelectorController {

    public TaxiForKittenSelectorController(TaxiSelectorService service) {
        super(service);
    }

    //핸들링할 Path 정보 추가 "POST /api/taxi-for-kittens-select-service/taxis"
}
