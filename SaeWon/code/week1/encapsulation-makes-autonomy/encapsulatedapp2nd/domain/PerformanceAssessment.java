package encapsulatedapp2nd.domain;

import java.time.LocalDate;

public class PerformanceAssessment {
    private Double maxDailyShippingVolume;
    private LocalDate firstReviewedDate;


    public Double getMaxDailyShippingVolume() {
        return maxDailyShippingVolume;
    }

    public LocalDate getFirstReviewedDate() {
        return firstReviewedDate;
    }
}
