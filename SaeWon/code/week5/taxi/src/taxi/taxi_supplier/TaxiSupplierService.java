package taxi.taxi_supplier;

import taxi.common.Taxi;
import taxi.taxi_finder.AvailableTaxiCondition;

import java.util.List;

public abstract class TaxiSupplierService {
    private final TaxiSupplier taxiSupplier;

    public TaxiSupplierService(TaxiSupplier taxiSupplier) {
        this.taxiSupplier = taxiSupplier;
    }

    public List<Taxi> findAvailableTaxiForRidesList(AvailableTaxiCondition condition){
        return taxiSupplier.findAllByCondition(condition);
    }

    public void dispatch(String taxiId) {
        DispatchableTaxi taxi = (DispatchableTaxi)taxiSupplier.findById(taxiId);
        taxi.dispatch();
        taxiSupplier.save(taxi);
    }
}
