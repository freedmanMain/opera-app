package opera.app.spring.service.dto.mapping.impl.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import opera.app.spring.model.Performance;
import opera.app.spring.model.PerformanceSession;
import opera.app.spring.model.Stage;
import opera.app.spring.model.dto.request.PerformanceSessionRequestDto;
import opera.app.spring.service.PerformanceService;
import opera.app.spring.service.StageService;
import opera.app.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionRequestMapper implements
        DtoRequestMapper<PerformanceSessionRequestDto,
        PerformanceSession> {
    public static final String PATTERN = "dd.MM.yyyy HH:mm";
    private final StageService stageService;
    private final PerformanceService performanceService;

    public PerformanceSessionRequestMapper(StageService stageService,
                                           PerformanceService performanceService) {
        this.stageService = stageService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSession fromDto(PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession = new PerformanceSession();
        Performance performance = performanceService.get(dto.getStageId());
        Stage stage = stageService.get(dto.getPerformanceId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        performanceSession.setMovie(performance);
        performanceSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        performanceSession.setCinemaHall(stage);
        return performanceSession;
    }
}
