package taxi.common;

import java.time.LocalDateTime;

public class Taxi{
    private String taxiId;
    private LocalDateTime arrivalTime;
    private boolean isVip;

    protected Status status;

    public Taxi(LocalDateTime arrivalTime, boolean isVip) {
        this.arrivalTime = arrivalTime;
        this.isVip = isVip;
    }

    protected enum Status {
        IDLE,
        DISPATCHED,
        ON_RIDING,
        OFF
    }
}
