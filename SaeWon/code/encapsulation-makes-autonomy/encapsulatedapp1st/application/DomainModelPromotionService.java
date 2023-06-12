package encapsulatedapp1st.application;

import encapsulatedapp1st.domain.CopangMan;
import encapsulatedapp1st.domain.PromotionPolicy;

import java.time.Duration;


/**
 * promotionPolicy로 한단계 캡슐화.
 * 이 과정에서 도메인패키지를 분리했고 package-private를 활용하여 도메인간의 통신레이어를 분리함.
 * 더이상 변경요구사항에 대해서 Service가 많은 것을 의존하지 않기 때문에 고유의 Service로직에 집중할 수 있음.
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
 *요구사항 반영
 * 1. 요구사항 1을 수행하기 위해서 performanceAssessment의 maxDailyShippingVolume필드값을 averageDailyShippingVolume으로 변경하면,
 *    promote도 수정함에도 Service단에서는 필드값을 의존하지 않아 변경이 없어 고유의 어플리케이션로직에 집중할 수 있음.
 * 2. 캠프리더 평가점수를 추가하려면 performancAssessment에 leaderReview필드값을 추가함과 동시에 Service단에 새 조건을 추가해주어야함.
 *    하지만, 마찬가지로 필드값을 알지 않아도 되기 때문에 위와 같은 장점이 생김.
 * 3. 조건을 추가할수록 개별 필드마다 PromotionPolicy는 모든것을 떠안은 상태라 여전히 추후 확장이 어려워짐.
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


