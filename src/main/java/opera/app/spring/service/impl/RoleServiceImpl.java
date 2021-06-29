package opera.app.spring.service.impl;

import opera.app.spring.dao.RoleDao;
import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.Role;
import opera.app.spring.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleDao.getByRoleName(roleName).orElseThrow(() -> new DataProcessingException(
                "Can't find role with name " + roleName));
    }
}
