package opera.app.spring.security;

import opera.app.spring.exception.AuthenticationException;
import opera.app.spring.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
