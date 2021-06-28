package opera.app.spring.service.dto.mapping.impl.request;

import opera.app.spring.model.Stage;
import opera.app.spring.model.dto.request.StageRequestDto;
import opera.app.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class StageRequestMapper implements DtoRequestMapper<StageRequestDto, Stage> {
    @Override
    public Stage fromDto(StageRequestDto dto) {
        Stage stage = new Stage();
        stage.setCapacity(dto.getCapacity());
        stage.setDescription(dto.getDescription());
        return stage;
    }
}
