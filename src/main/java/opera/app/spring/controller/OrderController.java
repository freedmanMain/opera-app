package opera.app.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import opera.app.spring.exception.DataProcessingException;
import opera.app.spring.model.ShoppingCart;
import opera.app.spring.model.User;
import opera.app.spring.model.dto.response.OrderResponseDto;
import opera.app.spring.service.OrderService;
import opera.app.spring.service.ShoppingCartService;
import opera.app.spring.service.UserService;
import opera.app.spring.service.dto.mapping.impl.response.OrderResponseMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final OrderResponseMapper orderResponseMapper;

    public OrderController(OrderService orderService,
                           ShoppingCartService shoppingCartService,
                           UserService userService,
                           OrderResponseMapper orderResponseMapper) {
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.orderResponseMapper = orderResponseMapper;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(Authentication authentication) {
        String email = authentication.getName();
        User userFromDb = userService.findByEmail(email)
                .orElseThrow(() -> new DataProcessingException(
                        "User not found by email + " + email));
        ShoppingCart cart = shoppingCartService.getByUser(userFromDb);
        return orderResponseMapper.toDto(orderService.completeOrder(cart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(Authentication authentication) {
        String email = authentication.getName();
        User userFromDb = userService.findByEmail(email)
                .orElseThrow(() -> new DataProcessingException(
                        "User not found by email + " + email));
        return orderService.getOrdersHistory(userFromDb).stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
