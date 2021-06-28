package opera.app.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import opera.app.spring.model.PerformanceSession;

public interface PerformanceSessionDao extends GenericDao<PerformanceSession> {
    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    Optional<PerformanceSession> get(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    boolean remove(Long id);
}
