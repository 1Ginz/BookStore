package bookstore.app.book.web.api;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CommentDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.Comment;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.IBookService;
import bookstore.app.book.service.ICommentService;
import bookstore.app.book.service.IUserService;
import bookstore.app.book.service.mapper.IConverterDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentApi {

    private final IBookService bookService;
    private final IAccountService accountService;
    private final ICommentService commentService;
    private final IUserService userService;



    @PostMapping("/add")
    public ResponseEntity<CommentDto> postComment(@RequestBody CommentDto commentDto,
                                                  @RequestParam String bookId,
                                                  Authentication authentication){
        Account account = accountService.getByUserName(authentication.getName());
        BookDto book = bookService.getById(Long.valueOf(bookId));
        UserDto userDto = userService.getByUserId(account.getUser().getId());
        commentDto.setUser(userDto);
        commentDto.setBook(book);
        try {
            commentDto = commentService.create(commentDto);
            return ResponseEntity.ok().body(commentDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllComment(){
        List<CommentDto> commentDtoList = (List<CommentDto>) commentService.getAll();
        System.out.println(commentDtoList);
        return ResponseEntity.ok().body(commentDtoList);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getAllCommentByBook(@PathVariable Long id){
        return ResponseEntity.ok().body(commentService.getByBook(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Long id){
        CommentDto commentDto = commentService.getById(id);
        return ResponseEntity.ok().body(commentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id,
                                            @RequestBody Map<String,String> commentDto, Authentication authentication){
        try {
            CommentDto current = commentService.getById(id);
            Long userId = accountService.getByUserName(authentication.getName()).getUser().getId();
            if(current.getUser().getId() != userId){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
            }
            current.setContent(commentDto.get("content"));
            CommentDto comment = commentService.update(id,current);
            return ResponseEntity.ok().body(comment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id,Authentication authentication){
        try {
            CommentDto comment = commentService.getById(id);
            Account account = accountService.getByUserName(authentication.getName());
            UserDto userDto = userService.getByUserId(account.getUser().getId());
            if(comment.getUser().getId() == userDto.getId()){
                commentService.deleteById(Long.valueOf(id));
                Map<String,String> response = new HashMap<>();
                response.put("message","Delete comment success");
                return ResponseEntity.ok().body(response);
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
