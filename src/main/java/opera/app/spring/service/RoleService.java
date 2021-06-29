package opera.app.spring.service;

import opera.app.spring.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(Role.RoleName roleName);
}
