package opera.app.spring.dao;

public interface GenericDao<T> {
    T add(T entity);
}
