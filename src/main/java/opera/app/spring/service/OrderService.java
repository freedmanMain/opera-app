package opera.app.spring.service;

import java.util.List;
import opera.app.spring.model.Order;
import opera.app.spring.model.ShoppingCart;
import opera.app.spring.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
