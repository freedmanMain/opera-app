package opera.app.spring.dao;

import java.util.Optional;
import opera.app.spring.model.User;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByEmail(String email);

    Optional<User> get(Long id);
}
