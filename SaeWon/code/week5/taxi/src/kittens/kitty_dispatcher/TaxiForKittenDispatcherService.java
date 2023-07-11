package kittens.kitty_dispatcher;

import taxi.taxi_dispatcher.TaxiDispatchHistoryRepository;
import taxi.taxi_dispatcher.TaxiDispatchNotifier;
import taxi.taxi_dispatcher.TaxiDispatcherService;

public class TaxiForKittenDispatcherService extends TaxiDispatcherService {
    public TaxiForKittenDispatcherService(TaxiDispatchNotifier notifier,
                                          TaxiDispatchHistoryRepository historyRepository) {
        super(supplier, notifier, historyRepository);
    }
}
