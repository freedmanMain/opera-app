package opera.app.spring.controller;

import opera.app.spring.model.User;
import opera.app.spring.model.dto.request.UserRequestDto;
import opera.app.spring.model.dto.response.UserResponseDto;
import opera.app.spring.security.AuthenticationService;
import opera.app.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseMapper userResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User registeredUser = authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userResponseMapper.toDto(registeredUser);
    }
}
