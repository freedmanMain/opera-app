package opera.app.spring.dao.impl;

import java.util.List;
import opera.app.spring.dao.AbstractDao;
import opera.app.spring.dao.OrderDao;
import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.Order;
import opera.app.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("FROM Order o "
                    + "LEFT JOIN FETCH o.tickets "
                    + "LEFT JOIN FETCH o.user "
                    + "WHERE o.user = :user", Order.class);
            query.setParameter("user", user);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find orders of user by user: " + "user", e);
        }
    }
}
