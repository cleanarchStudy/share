package encapsulatedapp2nd.domain.condition;

import encapsulatedapp2nd.domain.CopangMan;
import encapsulatedapp2nd.domain.PromotionCondition;

import java.time.Duration;
import java.time.LocalDate;

public class ReviewDurationPromotionCondition implements PromotionCondition {

    private final Duration minimumReviewDuration;

    public ReviewDurationPromotionCondition(Duration minimumReviewDuration) {
        this.minimumReviewDuration = minimumReviewDuration;
    }

    @Override
    public boolean isSatisfiedWith(CopangMan copangMan) {
        LocalDate firstReviewedDate = copangMan.getLastAssessment()
                                               .getFirstReviewedDate();
        Duration reviewDuration = getReviewDuration(firstReviewedDate);

        return reviewDuration.compareTo(minimumReviewDuration) >= 0;
    }

    private Duration getReviewDuration(LocalDate firstReviewedDate) {
        LocalDate nowDate = LocalDate.now();
        return Duration.between(firstReviewedDate, nowDate)
                       .plusDays(1L);
    }

}
