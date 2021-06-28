package opera.app.spring.dao;

import java.util.List;
import opera.app.spring.model.Order;
import opera.app.spring.model.User;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrdersHistory(User user);
}
