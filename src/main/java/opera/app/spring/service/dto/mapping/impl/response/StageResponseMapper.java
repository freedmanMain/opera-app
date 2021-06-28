package opera.app.spring.service.dto.mapping.impl.response;

import opera.app.spring.model.Stage;
import opera.app.spring.model.dto.response.StageResponseDto;
import opera.app.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class StageResponseMapper implements DtoResponseMapper<StageResponseDto,
        Stage> {
    @Override
    public StageResponseDto toDto(Stage stage) {
        StageResponseDto stageResponseDto = new StageResponseDto();
        stageResponseDto.setId(stage.getId());
        stageResponseDto.setCapacity(stage.getCapacity());
        return stageResponseDto;
    }
}
