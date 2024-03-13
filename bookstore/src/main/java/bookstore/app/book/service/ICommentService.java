package bookstore.app.book.service;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CommentDto;
import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.Comment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentService extends IServiceAdapter<CommentDto> {

    List<CommentDto> getByBook(Long bookId);

}
