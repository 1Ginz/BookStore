package bookstore.app.book.web.MVC.admin;

import bookstore.app.book.config.AppConfig;
import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.entity.User;
import bookstore.app.book.service.*;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/admin/books")
@Controller
@AllArgsConstructor
public class AdminBookController {

    private final IBookService bookService;
    private final AppConfig appConfig;
    private final ICategoryService categoryService;
    private final IAccountService accountService;



    @GetMapping("/")
    public String getAll(Authentication authentication,
                         Model model){
        if (authentication != null) {
            Account account = accountService.getByUserName(authentication.getName());
            User user = account.getUser();
            model.addAttribute("user",user);
        }
        List<BookDto> bookDtos = (List<BookDto>) bookService.getAll();
        model.addAttribute("books",bookDtos);
        return "admin-books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable String id,
                          Model model){
        try {
            BookDto book= bookService.getById(Long.valueOf(id));
            model.addAttribute("book",book);
            List<CategoryDto> categories = (List<CategoryDto>) categoryService.getAll();
            model.addAttribute("categories",categories);
            System.out.println(book.getImgCover());
            return "book-detail-admin";
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "book-detail-admin";
    }

    @GetMapping("/add")
    public String getAdd(Model model){
        BookDto book = bookService.getById((long)-1);
        List<CategoryDto> categories = (List<CategoryDto>) categoryService.getAll();
        model.addAttribute("categories",categories);
        model.addAttribute("book",book);
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") BookDto book,
//                          @RequestParam("releaseDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate,
                          BindingResult result,
                          @RequestParam("imgcover") MultipartFile multipartFile
    ) {
        try {
            if (result.hasErrors()){
                System.out.println(result.getAllErrors());
                return "add-book";
            }
//            book.setReleaseDate(releaseDate);
            book = bookService.create(book);
            if(!multipartFile.isEmpty()){
                uploadImage(multipartFile,"book",book);
            }

            bookService.update(book.getId(),book);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/admin/books/";
    }

    @PutMapping("/{id}")
    public String updateBook( @Valid @ModelAttribute ("book") BookDto book,
                              @PathVariable String id,
                              @RequestParam("imgcover") MultipartFile multipartFile,
                              BindingResult result
    ) throws Exception {
        try {
            if(result.hasErrors()){
                System.out.println(result.getAllErrors());
                return "book-detail-admin";
            }
            if (!multipartFile.isEmpty()){
                uploadImage(multipartFile,"book",book);
            }
            bookService.update(Long.valueOf(id),book);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/books/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id, Model model){
        try {
            bookService.deleteById(Long.valueOf(id));
            return "redirect:/admin/books/";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/books/";
    }

    private void uploadImage(MultipartFile multipartFile,String folder,BookDto book) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        book.setImgCover(fileName);
        String uploadDir = "./" + appConfig.getFileUploadPath() + "/"+ folder +"/" + book.getId();
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException IOE){
            IOE.printStackTrace();
        }
    }
}
