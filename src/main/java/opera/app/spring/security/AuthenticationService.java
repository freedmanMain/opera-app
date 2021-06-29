package opera.app.spring.security;

import opera.app.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
