package opera.app.spring.controller;

import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.User;
import opera.app.spring.model.dto.response.UserResponseDto;
import opera.app.spring.service.UserService;
import opera.app.spring.service.dto.mapping.impl.response.UserResponseMapper;
import opera.app.spring.validation.Email;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    public UserController(UserService userService, UserResponseMapper userResponseMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUser(@RequestParam @Email String email) {
        User userByEmail = userService.findByEmail(email)
                .orElseThrow(() -> new DataProcessingException("Can't find user by email" + email));
        return userResponseMapper.toDto(userByEmail);
    }
}
