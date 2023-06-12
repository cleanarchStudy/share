package encapsulatedapp2nd.domain.condition;

import encapsulatedapp2nd.domain.CopangMan;
import encapsulatedapp2nd.domain.PromotionCondition;

public class CampPromotionCondition implements PromotionCondition {

    private final String targetCamp;

    public CampPromotionCondition(String targetCamp) {
        this.targetCamp = targetCamp;
    }

    @Override
    public boolean isSatisfiedWith(CopangMan copangMan) {
        return copangMan.getCamp().equals(targetCamp);
    }

}
