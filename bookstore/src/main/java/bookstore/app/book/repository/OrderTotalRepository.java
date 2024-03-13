package bookstore.app.book.repository;

import bookstore.app.book.entity.OrderTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTotalRepository extends JpaRepository<OrderTotal,Long> {
}
