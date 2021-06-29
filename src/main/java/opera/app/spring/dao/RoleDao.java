package opera.app.spring.dao;

import opera.app.spring.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByRoleName(Role.RoleName name);
}
