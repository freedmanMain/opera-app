package opera.app.spring.service.impl;

import java.util.List;
import opera.app.spring.dao.PerformanceDao;
import opera.app.spring.model.Performance;
import opera.app.spring.service.PerformanceService;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id).get();
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }
}
