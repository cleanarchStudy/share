package taxi.taxi_finder;

import taxi.common.Taxi;

import java.util.List;

public abstract class TaxiFinderService {
    private final List<TaxiSupplierUsecase> suppliers;
    private final AvailableTaxiCondition condition;

    public TaxiFinderService(List<TaxiSupplierUsecase> suppliers, AvailableTaxiCondition condition) {
        this.suppliers = suppliers;
        this.condition = condition;
    }

    public List<Taxi> getTaxis() {
        return suppliers.stream()
                .flatMap(supplier -> supplier.findAvailableTaxiList(condition).stream())
                .toList();
    }

    protected List<TaxiSupplierUsecase> getSuppliers() {
        return suppliers;
    }

    protected AvailableTaxiCondition getCondition() {
        return condition;
    }
}
