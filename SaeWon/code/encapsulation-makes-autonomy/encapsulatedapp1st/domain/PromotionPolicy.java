package encapsulatedapp1st.domain;

import java.time.Duration;
import java.time.LocalDate;

/**
 * 여전히 PromotionPolicy는 여러 조건들과 강한 결합을 갖고있어 추후 변경확장이 어려움.
 * 여러 새로운 승진조건이 추가될때마다 필드값을 추가해주고 바꿔야함.
* */
public class PromotionPolicy {
    private String targetCamp;
    private Duration maximumReviewPeriod;
    private Duration minimumTenureInDays;
    private Integer minimumMaxDailyShippingVolume;

    public PromotionPolicy(String targetCamp, Duration maximumReviewPeriod, Duration minimumTenureInDays, Integer minimumMaxDailyShippingVolume) {
        this.targetCamp = targetCamp;
        this.maximumReviewPeriod = maximumReviewPeriod;
        this.minimumTenureInDays = minimumTenureInDays;
        this.minimumMaxDailyShippingVolume = minimumMaxDailyShippingVolume;
    }

    public void promote(CopangMan copangMan){
        // 요구사항 1
        if(!copangMan.getCamp().equals(targetCamp)) return;

        // 요구사항 2
        PerformanceAssessment lastAssessment = copangMan.getLastAssessment();
        LocalDate firstReviewedDate = lastAssessment.getFirstReviewedDate();
        LocalDate now = LocalDate.now();
        Duration reviewPeriod = Duration
                .between(firstReviewedDate, now)
                .plusDays(1L);// 초일산입
        if(reviewPeriod.compareTo(maximumReviewPeriod) > 0) return;

        // 요구사항 3
        Duration tenureInDays = Duration.between(copangMan.getJoinDate(), now)
                .plusDays(1L);// 초일산입
        if(tenureInDays.compareTo(minimumTenureInDays) < 0) return;

        // 요구사항 4
        if(lastAssessment.getMaxDailyShippingVolume() < minimumMaxDailyShippingVolume) return;

        // 진급
        copangMan.getPromoted();
    }
}
