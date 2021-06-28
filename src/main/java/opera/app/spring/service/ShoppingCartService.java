package opera.app.spring.service;

import opera.app.spring.model.PerformanceSession;
import opera.app.spring.model.ShoppingCart;
import opera.app.spring.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}
