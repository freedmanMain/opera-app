package opera.app.spring.controller;

import opera.app.spring.model.PerformanceSession;
import opera.app.spring.model.User;
import opera.app.spring.model.dto.response.ShoppingCartResponseDto;
import opera.app.spring.service.PerformanceSessionService;
import opera.app.spring.service.ShoppingCartService;
import opera.app.spring.service.UserService;
import opera.app.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
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

    @PostMapping("/stage")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long stageId) {
        User user = userService.get(userId);
        PerformanceSession performanceSession = performanceSessionService.get(stageId);
        shoppingCartService.addSession(performanceSession, user);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(user));
    }
}
