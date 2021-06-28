package opera.app.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import opera.app.spring.model.Stage;
import opera.app.spring.model.dto.request.StageRequestDto;
import opera.app.spring.model.dto.response.StageResponseDto;
import opera.app.spring.service.StageService;
import opera.app.spring.service.dto.mapping.DtoRequestMapper;
import opera.app.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;
    private final DtoRequestMapper<StageRequestDto, Stage> stageDtoRequestMapper;
    private final DtoResponseMapper<StageResponseDto, Stage> stageDtoResponseMapper;

    public StageController(StageService stageService,
                           DtoRequestMapper<StageRequestDto, Stage>
                                   stageDtoRequestMapper,
                           DtoResponseMapper<StageResponseDto, Stage>
                                   stageDtoResponseMapper) {
        this.stageService = stageService;
        this.stageDtoRequestMapper = stageDtoRequestMapper;
        this.stageDtoResponseMapper = stageDtoResponseMapper;
    }

    @PostMapping
    public StageResponseDto addCinemaHall(@RequestBody @Valid StageRequestDto dto) {
        Stage stage = stageService.add(stageDtoRequestMapper.fromDto(dto));
        return stageDtoResponseMapper.toDto(stage);
    }

    @GetMapping
    public List<StageResponseDto> getAllCinemaHalls() {
        return stageService.getAll().stream()
                .map(stageDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
