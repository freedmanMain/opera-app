package opera.app.spring.controller;

import javax.validation.constraints.Min;
import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.PerformanceSession;
import opera.app.spring.model.User;
import opera.app.spring.model.dto.response.ShoppingCartResponseDto;
import opera.app.spring.service.PerformanceSessionService;
import opera.app.spring.service.ShoppingCartService;
import opera.app.spring.service.UserService;
import opera.app.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final PerformanceSessionService performanceSessionService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  PerformanceSessionService performanceSessionService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.performanceSessionService = performanceSessionService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PostMapping("/performance-sessions")
    public ShoppingCartResponseDto addMovieSession(Authentication authentication,
                                                   @RequestParam @Min(1) Long sessionId) {
        String email = authentication.getName();
        User userFromDb = userService.findByEmail(email)
                .orElseThrow(() -> new DataProcessingException(
                        "User not found by email + " + email));
        PerformanceSession performanceSession = performanceSessionService.get(sessionId);
        shoppingCartService.addSession(performanceSession, userFromDb);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(userFromDb));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        String email = authentication.getName();
        User userFromDb = userService.findByEmail(email)
                .orElseThrow(() -> new DataProcessingException(
                        "User not found by email + " + email));
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(userFromDb));
    }
}
