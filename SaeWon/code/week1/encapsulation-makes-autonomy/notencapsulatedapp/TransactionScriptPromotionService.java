package notencapsulatedapp;

import java.time.Duration;
import java.time.LocalDate;


/**
 * 캡슐화가 되지 않은 객체가 발생하는 강한 결합도에 의해 변경에 자유롭지 못한 상태임
 *
 * 예외는 편의상 null로;
 * 강한 결합도를 보기 용이하기 위해 메서드를 쪼개지 않고 주석으로 대체.
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
 * 변경 애로사항
 * 1. 요구사항 1을 수행하기 위해서 performanceAssessment의 maxDailyShippingVolume필드값을 averageDailyShippingVolume으로 변경하면,promote도 수정해야함.
 * 2. 캠프리더 평가점수를 추가하려면 performancAssessment에 leaderReview필드값을 추가함과 동시에 Service단에 새 조건을 추가해주어야함.
 * 3. 조건을 추가할수록 개별 필드마다 서비스단에서 모든것을 의존하게되어 추후 확장이 어려워짐.
 * */
public class TransactionScriptPromotionService {

    public PromotionPolicy promotionPolicy = new PromotionPolicy(
            "강남",
            Duration.ofDays(365),
            Duration.ofDays(365),
            200);

    public void promote(CopangMan copangMan){
        if(copangMan == null) return;

        // 요구사항 1
        if(!copangMan.camp.equals(promotionPolicy.targetCamp)) return;

        // 요구사항 2
        PerformanceAssessment lastAssessment = copangMan.lastAssessment;
        LocalDate firstReviewedDate = lastAssessment.firstReviewedDate;
        LocalDate now = LocalDate.now();
        Duration reviewPeriod = Duration
                                .between(firstReviewedDate, now)
                                .plusDays(1L);
        if(reviewPeriod.compareTo(promotionPolicy.maximumReviewPeriod) > 0) return;

        // 요구사항 3
        Duration tenureInDays = Duration.between(copangMan.joinDate, now)
                                        .plusDays(1L);// 초일산입
        if(tenureInDays.compareTo(promotionPolicy.minimumTenureInDays) < 0) return;

        // 요구사항 4
        if(lastAssessment.maxDailyShippingVolume < promotionPolicy.minimumMaxDailyShippingVolume) return;

        // 진급
        copangMan.level++;
    }


    static class CopangMan {
        public String name;
        public Integer level;
        public String camp;
        public PerformanceAssessment lastAssessment;
        public LocalDate joinDate;

    }

    static class PerformanceAssessment {
        public Double maxDailyShippingVolume;
        public LocalDate firstReviewedDate;
    }

    static class PromotionPolicy {
        public String targetCamp;
        public Duration maximumReviewPeriod;
        public Duration minimumTenureInDays;
        public Integer minimumMaxDailyShippingVolume;

        public PromotionPolicy(String targetCamp, Duration maximumReviewPeriod, Duration minimumTenureInDays, Integer minimumMaxDailyShippingVolume) {
            this.targetCamp = targetCamp;
            this.maximumReviewPeriod = maximumReviewPeriod;
            this.minimumTenureInDays = minimumTenureInDays;
            this.minimumMaxDailyShippingVolume = minimumMaxDailyShippingVolume;
        }
    }

}


