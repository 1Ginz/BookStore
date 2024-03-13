package bookstore.app.book.config;

//import com.shop.bookshop.DTO.BookDto;
//import com.shop.bookshop.DTO.UserDto;
//import com.shop.bookshop.Entity.Book;
//import com.shop.bookshop.Entity.User;
//import com.shop.bookshop.Service.mapper.impl.BookMapper;
//import com.shop.bookshop.Service.mapper.impl.UserMapper;
import bookstore.app.book.dto.*;
import bookstore.app.book.entity.*;
import bookstore.app.book.service.impl.UserService;
import bookstore.app.book.service.mapper.impl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationCustomeRegisterBean {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean(name = "bookMapper")
    public BookMapper getBookMapper(){
        return new BookMapper(Book.class, BookDto.class);
    }

    @Bean(name = "categoryMapper")
    public CategoryMapper getCategoryMapper(){
        return new CategoryMapper(Category.class, CategoryDto.class);
    }

    @Bean(name = "userMapper")
    public UserMapper getUserMapper(){
        return new UserMapper(User.class, UserDto.class);
    }

    @Bean(name = "commentMapper")
    public CommentMapper getCommentMapper(){return new CommentMapper(Comment.class,CommentDto.class);}

    @Bean(name = "OrderDetailMapper")
    public OrderDetailMapper getOrderDetailMapper(){
        return new OrderDetailMapper(OrderDetail.class, OrderDetailDto.class);
    }

    @Bean(name = "OrderTotalMapper")
    public OrderTotalMapper getOrderTotalMapper(){
        return new OrderTotalMapper(OrderTotal.class, OrderTotalDto.class);
    }

    @Bean(name = "CheckoutDetailMapper")
    public CheckOutDetailMapper getCheckOutDetailMapper(){
        return new CheckOutDetailMapper(CheckoutDetail.class, CheckOutDetailDto.class);
    }

    @Bean(name = "CheckoutMapper")
    public CheckOutMapper getCheckOutMapper(){
        return new CheckOutMapper(Checkout.class, CheckoutDto.class);
    }

}
