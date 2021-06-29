package opera.app.spring.dao;

import java.util.Optional;
import opera.app.spring.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByRoleName(Role.RoleName name);
}
