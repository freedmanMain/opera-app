package opera.app.spring.service.impl;

import java.util.List;
import opera.app.spring.dao.StageDao;
import opera.app.spring.model.Stage;
import opera.app.spring.service.StageService;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public Stage get(Long id) {
        return stageDao.get(id).get();
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }
}
