package opera.app.spring.service;

import java.util.List;
import opera.app.spring.model.Stage;

public interface StageService {
    Stage add(Stage stage);

    Stage get(Long id);

    List<Stage> getAll();
}
