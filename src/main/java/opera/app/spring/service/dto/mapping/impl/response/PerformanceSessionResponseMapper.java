package opera.app.spring.service.dto.mapping.impl.response;

import java.time.format.DateTimeFormatter;
import opera.app.spring.model.PerformanceSession;
import opera.app.spring.model.dto.response.PerformanceSessionResponseDto;
import opera.app.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionResponseMapper implements
        DtoResponseMapper<PerformanceSessionResponseDto,
        PerformanceSession> {
    @Override
    public PerformanceSessionResponseDto toDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto performanceSessionResponseDto =
                new PerformanceSessionResponseDto();
        performanceSessionResponseDto.setId(performanceSession.getId());
        performanceSessionResponseDto
                .setMovieTitle(performanceSession.getMovie().getTitle());
        performanceSessionResponseDto
                .setShowTime(performanceSession.getShowTime().format(DateTimeFormatter
                                                    .ofPattern("dd.MM.yyyy HH:mm")));
        performanceSessionResponseDto
                .setCinemaHallCapacity(performanceSession.getCinemaHall().getCapacity());
        return performanceSessionResponseDto;
    }
}
