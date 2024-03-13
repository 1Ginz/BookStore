package bookstore.app.book.web.api;

import bookstore.app.book.config.AppConfig;
import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.entity.User;
import bookstore.app.book.service.IBookService;
import bookstore.app.book.service.impl.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookApi {

    private final IBookService bookService;
    private final AppConfig appConfig;


    //all book
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(bookService.getAll());
    }

//   pageable
    @GetMapping("/pageable")
    public ResponseEntity<?> getAllPageable(@RequestParam(name = "pageNumber",required = false) String pageNumber,
                                    @RequestParam(name = "limitParam", required = false) String limitParam,
                                    @RequestParam(name = "sort_by", required = false, defaultValue = "id") String sortBy,
                                    @RequestParam(name = "type_sort", required = false,defaultValue = "ASC") String typeSort){
        int currentPage = pageNumber == null ? 0 : Integer.valueOf(pageNumber);
        int limit = limitParam == null ? 15 : Integer.valueOf(limitParam);
        Sort sort;
        if(typeSort.equals("ASC")){
            sort = Sort.by(Sort.Direction.ASC,sortBy);
        }else{
            sort = Sort.by(Sort.Direction.DESC,sortBy);
        }
        Pageable pageable = PageRequest.of(currentPage,limit,sort);
        Page<BookDto> bookDtos = bookService.getAll(pageable);
        return ResponseEntity.ok().body(bookDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        BookDto bookDto = bookService.getById(id);
        if(bookDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookDto);
    }

    @PostMapping("/add")
    public ResponseEntity<BookDto> addBook(@Valid @ModelAttribute() BookDto book,
                          BindingResult result,
                          @RequestParam("imgcover") MultipartFile multipartFile
    ) {
        try {
            if (result.hasErrors()){
                System.out.println(result.getAllErrors());
                return ResponseEntity.badRequest().build();
            }
//            book.setReleaseDate(releaseDate);
            book = bookService.create(book);
            if(!multipartFile.isEmpty()){
                uploadImage(multipartFile,"book",book);
            }

            BookDto newBook = bookService.update(book.getId(),book);
            return ResponseEntity.ok().body(newBook);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook( @Valid @ModelAttribute() BookDto book,
                              @PathVariable String id,
                              @RequestParam("imgcover") MultipartFile multipartFile,
                              BindingResult result
    ) {
        try {
            if(result.hasErrors()){
                System.out.println(result.getAllErrors());
                return ResponseEntity.badRequest().build();
            }
            if (!multipartFile.isEmpty()){
                uploadImage(multipartFile,"book",book);
            }
            BookDto newBook = bookService.update(Long.valueOf(id),book);
            return ResponseEntity.ok().body(newBook);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        Map<String,String> returnMessage = new HashMap<>();
        try {
            bookService.deleteById(Long.valueOf(id));
            returnMessage.put("message","delete book success");
            return ResponseEntity.ok().body(returnMessage);
        } catch (Exception e) {
            e.printStackTrace();
            returnMessage.put("message","delete book failed");
            return ResponseEntity.badRequest().body(returnMessage);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getBookByCategory(
                                    @PathVariable String id,
                                    @RequestParam(name = "sort_by", required = false) String sortBy,
                                    @RequestParam(name = "type_sort", required = false) String typeSort
    ){
        List<BookDto> listBookDto = (List<BookDto>) bookService.getByCategory(id);
        if("ASC".equals(typeSort)){
            listBookDto.sort(
                    (o1,o2) -> o1.getPrice().compareTo(o2.getPrice())
            );
        }
        if("DESC".equals(typeSort)){
            listBookDto.sort(
                    (o1,o2) -> o2.getPrice().compareTo(o1.getPrice())
            );
        }
        return ResponseEntity.ok().body(listBookDto);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<?> findBook(
                           @PathVariable("search") String search,
                           @RequestParam(name = "type_sort", required = false) String typeSort
    ){
        List<BookDto> listBookDto = (List<BookDto>) bookService.searchBook(search);

        if("ASC".equals(typeSort)){
            listBookDto.sort(
                    (o1,o2) -> o1.getPrice().compareTo(o2.getPrice())
            );
        }
        if("DESC".equals(typeSort)){
            listBookDto.sort(
                    (o1,o2) -> o2.getPrice().compareTo(o1.getPrice())
            );
        }

        return ResponseEntity.ok().body(listBookDto);
    }

    private void uploadImage(MultipartFile multipartFile, String folder, BookDto book) throws IOException {
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
