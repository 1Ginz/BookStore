package bookstore.app.book.web.MVC.Controller;

import bookstore.app.book.config.AppConfig;
import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.dto.CommentDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.Comment;
import bookstore.app.book.entity.User;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.IBookService;
import bookstore.app.book.service.ICategoryService;
import bookstore.app.book.service.ICommentService;
import bookstore.app.book.service.mapper.IConverterDto;
import bookstore.app.book.service.mapper.impl.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController  {

    private final IBookService bookService;
    private final AppConfig appConfig;
    private final ICategoryService categoryService;
    private final ICommentService commentService;
    private final IConverterDto<Book, BookDto> bookMapper;
    private final IAccountService accountService;

    @GetMapping("/{id}")
    public String getBook(@PathVariable String id,
                          Model model,
                          Authentication authentication){
        try {
            BookDto book= bookService.getById(Long.valueOf(id));
            model.addAttribute("book",book);
            List<CategoryDto> categories = (List<CategoryDto>) categoryService.getAll();
            model.addAttribute("categories",categories);
            List<CommentDto> comments = commentService.getByBook(book.getId());
            model.addAttribute("comments",comments);
            System.out.println(book.getImgCover());
            if (authentication != null) {
                Account account = accountService.getByUserName(authentication.getName());
                User user = account.getUser();
                model.addAttribute("user",user);
            }
            return "book-details";
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "book-details";
    }

    //add book
//    @GetMapping("/add")
//    public String getAdd(Model model){
//        BookDto book = bookService.getById((long)-1);
//        List<CategoryDto> categories = (List<CategoryDto>) categoryService.getAll();
//        model.addAttribute("categories",categories);
//        model.addAttribute("book",book);
//        return "add-book";
//    }
//
//    @PostMapping("/add")
//    public String addBook(@Valid @ModelAttribute("book") BookDto book,
//                          BindingResult result,
//                          @RequestParam("imgcover") MultipartFile multipartFile
//    ) {
//        try {
//            if (result.hasErrors()){
//                System.out.println(result.getAllErrors());
//                return "add-book";
//            }
//            book = bookService.create(book);
//            if(!multipartFile.isEmpty()){
//                uploadImage(multipartFile,"book",book);
//            }
//
//            bookService.update(book.getId(),book);
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return "redirect:/";
//    }
//
//    @PutMapping("/{id}")
//    public String updateBook( @Valid @ModelAttribute ("book") BookDto book,
//                              @PathVariable String id,
//                              @RequestParam("imgcover") MultipartFile multipartFile,
//                              BindingResult result
//    ) throws Exception {
//        try {
//            if(result.hasErrors()){
//                System.out.println(result.getAllErrors());
//                return "book-details";
//            }
//            if (!multipartFile.isEmpty()){
//                uploadImage(multipartFile,"book",book);
//            }
//            bookService.update(Long.valueOf(id),book);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteBook(@PathVariable String id, Model model){
//        try {
//            bookService.deleteById(Long.valueOf(id));
//            return "redirect:/";
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }
//
//    private void uploadImage(MultipartFile multipartFile,String folder,BookDto book) throws IOException {
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        book.setImgCover(fileName);
//        String uploadDir = "./" + appConfig.getFileUploadPath() + "/"+ folder +"/" + book.getId();
//        Path uploadPath = Paths.get(uploadDir);
//        if (!Files.exists(uploadPath)){
//            Files.createDirectories(uploadPath);
//        }
//        try {
//            InputStream inputStream = multipartFile.getInputStream();
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException IOE){
//            IOE.printStackTrace();
//        }
//    }

}

