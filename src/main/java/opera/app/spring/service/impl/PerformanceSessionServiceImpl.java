package opera.app.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import opera.app.spring.dao.PerformanceSessionDao;
import opera.app.spring.model.PerformanceSession;
import opera.app.spring.service.PerformanceSessionService;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao performanceSessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao performanceSessionDao) {
        this.performanceSessionDao = performanceSessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        return performanceSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public PerformanceSession get(Long id) {
        return performanceSessionDao.get(id).get();
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return performanceSessionDao.add(session);
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        return performanceSessionDao.update(performanceSession);
    }

    @Override
    public boolean remove(Long id) {
        return performanceSessionDao.remove(id);
    }
}
