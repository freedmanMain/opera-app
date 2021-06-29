package opera.app.spring.dao.impl;

import java.util.Optional;
import opera.app.spring.dao.AbstractDao;
import opera.app.spring.dao.RoleDao;
import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Role> getByRoleName(Role.RoleName name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query = session.createQuery("FROM Role r "
                    + "WHERE r.name = :name", Role.class);
            query.setParameter("name", name);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find role with name " + name, e);
        }
    }
}
