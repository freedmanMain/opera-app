package opera.app.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import opera.app.spring.dao.AbstractDao;
import opera.app.spring.dao.StageDao;
import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoImpl extends AbstractDao<Stage> implements StageDao {
    public StageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Stage> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Stage.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a stage by id: " + id, e);
        }
    }

    @Override
    public List<Stage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Stage> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Stage.class);
            criteriaQuery.from(Stage.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all stages", e);
        }
    }
}
