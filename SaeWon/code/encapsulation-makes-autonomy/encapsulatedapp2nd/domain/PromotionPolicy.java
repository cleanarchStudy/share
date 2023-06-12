package encapsulatedapp2nd.domain;

/**
 * Condition으로 인터페이스를 만들고 각각 캡슐화 한 결과 총 사라진 의존성이 5개
 * 이제 만족해야할 요구사항을 추가하거나 빼는데 Condition의 세부 구현은 몰라도 됨.
 * */
//import encapsulatedapp2nd.domain.CopangMan;
//import encapsulatedapp2nd.domain.PerformanceAssessment;
//import encapsulatedapp2nd.domain.PromotionCondition;
//
//import java.time.Duration;
//import java.time.LocalDate;

import java.util.List;

public class PromotionPolicy {
    private final List<PromotionCondition> allRequiredConditions;

    public PromotionPolicy(List<PromotionCondition> allRequiredConditions) {
        this.allRequiredConditions = allRequiredConditions;
    }

    public void promote(CopangMan copangMan){
        if(isPromoted(copangMan)) copangMan.getPromoted();
    }

    private boolean isPromoted(CopangMan copangMan) {
        return allRequiredConditions.stream()
                .allMatch(c -> c.isSatisfiedWith(copangMan));
    }
}
