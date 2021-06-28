package opera.app.spring.service.dto.mapping.impl.response;

import opera.app.spring.model.User;
import opera.app.spring.model.dto.response.UserResponseDto;
import opera.app.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements DtoResponseMapper<UserResponseDto, User> {

    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
