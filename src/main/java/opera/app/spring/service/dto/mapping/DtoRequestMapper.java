package opera.app.spring.service.dto.mapping;

public interface DtoRequestMapper<D, C> {
    C fromDto(D dto);
}
