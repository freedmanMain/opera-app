package opera.app.spring.dao;

import opera.app.spring.model.ShoppingCart;
import opera.app.spring.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
