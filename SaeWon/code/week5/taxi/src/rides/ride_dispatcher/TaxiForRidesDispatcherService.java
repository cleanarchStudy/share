package rides.ride_dispatcher;

import taxi.taxi_dispatcher.TaxiDispatchHistoryRepository;
import taxi.taxi_dispatcher.TaxiDispatchNotifier;
import taxi.taxi_dispatcher.TaxiDispatcherService;

public class TaxiForRidesDispatcherService extends TaxiDispatcherService {
    public TaxiForRidesDispatcherService(TaxiDispatchNotifier notifier,
                                         TaxiDispatchHistoryRepository historyRepository) {
        super(supplier, notifier, historyRepository);
    }
}
