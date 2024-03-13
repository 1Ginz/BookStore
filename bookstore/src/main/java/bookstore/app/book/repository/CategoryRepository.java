package bookstore.app.book.repository;

import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

//    Long@Query
}
