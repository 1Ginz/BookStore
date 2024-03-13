package bookstore.app.book.repository;

import bookstore.app.book.entity.Checkout;
import bookstore.app.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout,Long> {
    List<Checkout> findAllByUserOrderByIdDesc(User user);

    @Query("select c from Checkout c order by c.id desc")
    List<Checkout> findAllOrderByDesc();
}
