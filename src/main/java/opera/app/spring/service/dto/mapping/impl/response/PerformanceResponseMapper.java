package opera.app.spring.service.dto.mapping.impl.response;

import opera.app.spring.model.Performance;
import opera.app.spring.model.dto.response.PerformanceResponseDto;
import opera.app.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceResponseMapper implements
        DtoResponseMapper<PerformanceResponseDto, Performance> {
    @Override
    public PerformanceResponseDto toDto(Performance performance) {
        PerformanceResponseDto performanceResponseDto = new PerformanceResponseDto();
        performanceResponseDto.setId(performance.getId());
        performanceResponseDto.setTitle(performance.getTitle());
        performanceResponseDto.setDescription(performance.getDescription());
        return performanceResponseDto;
    }
}
