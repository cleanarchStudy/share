package taxi.taxi_supplier;

import taxi.common.Taxi;

import java.time.LocalDateTime;

public class DispatchableTaxi extends Taxi implements Dispatchable {

    public DispatchableTaxi(LocalDateTime arrivalTime, boolean isVip) {
        super(arrivalTime, isVip);
    }

    @Override
    public void dispatch() {
        if(super.status==Status.IDLE) super.status = Status.DISPATCHED;
    }
}
