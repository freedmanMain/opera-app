package opera.app.spring.model.dto.request;

import javax.validation.constraints.NotBlank;

public class PerformanceRequestDto {
    @NotBlank
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
