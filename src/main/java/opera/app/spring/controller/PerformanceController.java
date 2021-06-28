package opera.app.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import opera.app.spring.model.Performance;
import opera.app.spring.model.dto.request.PerformanceRequestDto;
import opera.app.spring.model.dto.response.PerformanceResponseDto;
import opera.app.spring.service.PerformanceService;
import opera.app.spring.service.dto.mapping.DtoRequestMapper;
import opera.app.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final DtoRequestMapper<PerformanceRequestDto,
            Performance> performanceDtoRequestMapper;
    private final DtoResponseMapper<PerformanceResponseDto,
            Performance> performanceDtoResponseMapper;

    public PerformanceController(PerformanceService performanceService,
                                 DtoRequestMapper<PerformanceRequestDto,
                                         Performance> performanceDtoRequestMapper,
                                 DtoResponseMapper<PerformanceResponseDto,
                                         Performance> performanceDtoResponseMapper) {
        this.performanceService = performanceService;
        this.performanceDtoRequestMapper = performanceDtoRequestMapper;
        this.performanceDtoResponseMapper = performanceDtoResponseMapper;
    }

    @PostMapping
    public PerformanceResponseDto addMovie(@RequestBody PerformanceRequestDto dto) {
        Performance performance = performanceService.add(performanceDtoRequestMapper.fromDto(dto));
        return performanceDtoResponseMapper.toDto(performance);
    }

    @GetMapping
    public List<PerformanceResponseDto> getAllMovies() {
        return performanceService.getAll().stream()
                .map(performanceDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
