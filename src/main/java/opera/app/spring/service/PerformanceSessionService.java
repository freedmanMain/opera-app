package opera.app.spring.service;

import java.time.LocalDate;
import java.util.List;
import opera.app.spring.model.PerformanceSession;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession get(Long id);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession update(PerformanceSession performanceSession);

    boolean remove(Long id);
}
