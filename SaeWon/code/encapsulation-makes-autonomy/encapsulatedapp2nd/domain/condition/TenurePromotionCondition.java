package encapsulatedapp2nd.domain.condition;

import encapsulatedapp2nd.domain.CopangMan;
import encapsulatedapp2nd.domain.PromotionCondition;

import java.time.Duration;
import java.time.LocalDate;

public class TenurePromotionCondition implements PromotionCondition {
    private final Duration minimumTenureInDays;

    public TenurePromotionCondition(Duration minimumTenureInDays) {
        this.minimumTenureInDays = minimumTenureInDays;
    }

    @Override
    public boolean isSatisfiedWith(CopangMan copangMan) {
        LocalDate joinDate = copangMan.getJoinDate();
        Duration tenureInDays = getTenureInDays(joinDate);
        return tenureInDays.compareTo(minimumTenureInDays) >= 0;
    }

    private Duration getTenureInDays(LocalDate joinDate) {
        LocalDate nowDate = LocalDate.now();
        return Duration.between(joinDate, nowDate).plusDays(1L);
    }
}
