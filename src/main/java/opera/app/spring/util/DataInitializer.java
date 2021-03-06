package opera.app.spring.util;

import java.util.Set;
import javax.annotation.PostConstruct;
import opera.app.spring.model.Role;
import opera.app.spring.model.User;
import opera.app.spring.service.RoleService;
import opera.app.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role user = new Role();
        user.setName(Role.RoleName.ROLE_USER);
        Role admin = new Role();
        admin.setName(Role.RoleName.ROLE_ADMIN);

        roleService.add(user);
        roleService.add(admin);

        User bob = new User();
        bob.setEmail("user@domain.com");
        bob.setPassword("qwerty");
        bob.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_USER)));
        userService.add(bob);

        User alice = new User();
        alice.setEmail("admin@gmail.com");
        alice.setPassword("qwerty12");
        alice.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_ADMIN)));
        userService.add(alice);
    }
}
