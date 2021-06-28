package opera.app.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import opera.app.spring.model.Order;
import opera.app.spring.model.Ticket;
import opera.app.spring.model.dto.response.OrderResponseDto;
import opera.app.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements
        DtoResponseMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate().toString());
        orderResponseDto.setUserId(order.getUser().getId());
        orderResponseDto.setTicketsId(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
