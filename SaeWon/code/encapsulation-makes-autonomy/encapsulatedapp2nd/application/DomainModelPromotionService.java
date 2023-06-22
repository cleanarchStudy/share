package encapsulatedapp2nd.application;

import encapsulatedapp1st.domain.CopangMan;
import encapsulatedapp1st.domain.PromotionPolicy;

import java.time.Duration;


/**
 * PromotionPolicy에 강하게 결합된 조건들을 PromotionCondition인터페이스로 각각 다른 책임을 캡슐화 하는것으로(정확히는 캡슐화에 다형성까지 사용됨 하지만, 해당 인터페이스는 자율성을 기반화함.)
 * 더이상 Policy가 강하게 조건을 알 필요가 없어지고, 요구사항을 자유롭게 추가할 수 있는 구조가 되었음.
 *
 *
 * 코팡맨 진급 서비스 초기 요구사항
 * 1. 캠프가 지정된 캠프일 것
 * 2. 평가자료가 1년 이내일 것
 * 3. 근속년수가 1개월이 넘었을 것
 * 4. 일 최대 배송량이 200건 이상일 것
 *
 * 요구사항 변경
 * 1. 평균 일 배송량이 아니라 평균 일일배송량이 200건이 넘었을 것
 * 2. 캠프리더 평가점수가 100점만점중 80점 이상
 * 3. 판교 캠프도 진급대상에 포함
 *
 * 요구사항 변경
 * 1. MaxShippingVolumePromotionCondition을 사용하지 않고, AverageShippingVolumePormotionCondition을 구현하면 코드변경 필요없음.
 * 2. LeaderReviewPromotionCondition 을 추가하여 확장하면 아무런 변경이 필요 없음.
 * 3. CampPromotionCondition에서 캠프필드를 List로 받고, stream.anyMatch()로 수정하면 CampPromotionCondition만 변경하는것으로 확장 가능
 *
 * 한계점
 * 1. PromotionCondition에 다형성을 활용하는 과정에서, promotionCondition은 copangMan의 lastAssessment를 알아야함.
 * */
public class DomainModelPromotionService {

    public PromotionPolicy promotionPolicy = new PromotionPolicy(
            "강남",
            Duration.ofDays(365),
            Duration.ofDays(365),
            200);

    public void promote(CopangMan copangMan){
        if(copangMan == null) return;
        promotionPolicy.promote(copangMan);
    }

}


