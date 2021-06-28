package opera.app.spring.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import opera.app.spring.dao.OrderDao;
import opera.app.spring.model.Order;
import opera.app.spring.model.ShoppingCart;
import opera.app.spring.model.User;
import opera.app.spring.service.OrderService;
import opera.app.spring.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setUser(shoppingCart.getUser());
        order.setTickets(new ArrayList<>(shoppingCart.getTickets()));
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clearShoppingCart(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
