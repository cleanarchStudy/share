package encapsulatedapp2nd.domain;

import java.time.LocalDate;

public class CopangMan {
    private String name;
    private Integer level;
    private String camp;
    private PerformanceAssessment lastAssessment;
    private LocalDate joinDate;

    void getPromoted() {
        if(level != null) level++;
    }

    public String getCamp() {
        return camp;
    }

    public PerformanceAssessment getLastAssessment() {
        return lastAssessment;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }
}
