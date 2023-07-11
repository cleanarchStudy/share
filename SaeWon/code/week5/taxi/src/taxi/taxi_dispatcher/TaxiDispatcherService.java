package taxi.taxi_dispatcher;

import taxi.taxi_selector.TaxiDispatcherUsecase;
import taxi.taxi_supplier.TaxiSupplierService;

public abstract class TaxiDispatcherService implements TaxiDispatcherUsecase {

    private final TaxiSupplierService supplier;
    private final TaxiDispatchNotifier notifier;
    private final TaxiDispatchHistoryRepository historyRepository;

    public TaxiDispatcherService(TaxiSupplierService supplier, TaxiDispatchNotifier notifier, TaxiDispatchHistoryRepository historyRepository) {
        this.supplier = supplier;
        this.notifier = notifier;
        this.historyRepository = historyRepository;
    }

    public void dispatch(String taxiId){
        supplier.dispatch(taxiId);
        notifier.notify(taxiId);
        historyRepository.save(taxiId);
    }
}
