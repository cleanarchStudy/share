package encapsulatedapp2nd.domain.condition;

import encapsulatedapp2nd.domain.CopangMan;
import encapsulatedapp2nd.domain.PromotionCondition;

public class MaxShippingVolumePromotionCondition implements PromotionCondition {

    private final Integer maximumDailyShippingVolume;

    public MaxShippingVolumePromotionCondition(Integer maximumDailyShippingVolume) {
        this.maximumDailyShippingVolume = maximumDailyShippingVolume;
    }

    @Override
    public boolean isSatisfiedWith(CopangMan copangMan) {
        Double copangManVolume = copangMan.getLastAssessment()
                                          .getMaxDailyShippingVolume();
        return copangManVolume >= maximumDailyShippingVolume;
    }
}
