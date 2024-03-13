package bookstore.app.book.service;

import bookstore.app.book.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.util.Collection;

public interface IServiceAdapter<T> {
    T create (T dto) throws Exception;
    T update(Long id, T dto) throws Exception;

    T getById(Long id);

    boolean deleteById(Long id) throws Exception;
    Collection<T> getAll();

    Page<T> getAll(Pageable pageable);
}
