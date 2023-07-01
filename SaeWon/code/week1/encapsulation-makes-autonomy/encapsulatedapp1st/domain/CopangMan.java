package encapsulatedapp1st.domain;

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

    String getCamp() {
        return camp;
    }

    PerformanceAssessment getLastAssessment() {
        return lastAssessment;
    }

    LocalDate getJoinDate() {
        return joinDate;
    }
}
