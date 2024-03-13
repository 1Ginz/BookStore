package bookstore.app.book.repository;

import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select distinct b from Book b where b.title like %:param% or b.author like %:param%")
    Set<Book> searchBook(@Param("param") String param);

//    @Query("select b from Book b where b.author like %:author%")
//    List<Book> searchBookByAuthor(@Param("author") String author);

    List<Book> findByCategory(Category category);

}
