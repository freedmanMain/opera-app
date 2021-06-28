package opera.app.spring.dao.impl;

import opera.app.spring.dao.AbstractDao;
import opera.app.spring.dao.TicketDao;
import opera.app.spring.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
