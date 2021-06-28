package opera.app.spring.model.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PerformanceSessionRequestDto {
    @NotNull
    @Min(1)
    private Long stageId;
    @NotNull
    private String showTime;
    @NotNull
    @Min(1)
    private Long performanceId;

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }
}
