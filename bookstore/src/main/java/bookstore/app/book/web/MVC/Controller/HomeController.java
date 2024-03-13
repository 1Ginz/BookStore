package bookstore.app.book.web.MVC.Controller;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.dto.UserDto;
import bookstore.app.book.entity.Account;
import bookstore.app.book.entity.Category;
import bookstore.app.book.entity.User;
import bookstore.app.book.service.IAccountService;
import bookstore.app.book.service.IBookService;
import bookstore.app.book.service.ICategoryService;
import bookstore.app.book.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private final IBookService bookService;
    private final ICategoryService categoryService;
    private final IUserService userService;
    private final IAccountService accountService;

    @GetMapping("")
    public String getHome(Model model,
                          Authentication authentication,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          HttpSession session,
                          @RequestParam(name = "pageNumber",required = false) String pageNumber,
                          @RequestParam(name = "limitParam", required = false) String limitParam,
                          @RequestParam(name = "sort_by", required = false, defaultValue = "id") String sortBy,
                          @RequestParam(name = "type_sort", required = false,defaultValue = "ASC") String typeSort){
        int currentPage = pageNumber == null ? 0 : Integer.valueOf(pageNumber);
        int limit = limitParam == null ? 15 : Integer.valueOf(limitParam);

        if (request.getSession().getAttribute("user") != null)
        {
            String s = request.getSession().getAttribute("user").toString();
            Account account = accountService.getByUserName(s);
            User user = account.getUser();
            model.addAttribute("user",user);
        }

        Sort sort;
        if(typeSort.equals("ASC")){
            sort = Sort.by(Sort.Direction.ASC,sortBy);
        }else{
            sort = Sort.by(Sort.Direction.DESC,sortBy);
        }
        Pageable pageable = PageRequest.of(currentPage,limit,sort);

        Page<BookDto> listBookDto = (Page<BookDto>) bookService.getAll(pageable);
        System.out.println(listBookDto.getTotalPages());
        model.addAttribute("totalPages",listBookDto.getTotalPages());
        model.addAttribute("pageNumber",currentPage);
        model.addAttribute("limit",limit);
        model.addAttribute("sort_by",sortBy);
        model.addAttribute("type_sort",typeSort);
        model.addAttribute("books",listBookDto);

        List<CategoryDto> category = (List<CategoryDto>) categoryService.getAll();
        model.addAttribute("category",category);
//        if (authentication != null)
//        {
//            Account account = accountService.getByUserName(authentication.getName());
//            User user = account.getUser();
//            model.addAttribute("user",user);
//        }
        System.out.println(session.getId());
        System.out.println(request.getSession().getAttribute("username"));
        if (request.getSession().getAttribute("username")!= null){
            Account account = accountService.getByUserName(
                    String.valueOf(request
                            .getSession()
                            .getAttribute("username")
                    )
            );
            User user = account.getUser();
            model.addAttribute("user",user);
        }
        return "home";
    }


    @GetMapping("/search/{search}")
    public String findBook(Model model,
                           Authentication authentication,
                           @PathVariable("search") String search,
                           @RequestParam(name = "type_sort", required = false) String typeSort
    ){
        List<CategoryDto> category = (List<CategoryDto>) categoryService.getAll();
        model.addAttribute("category",category);

        List<BookDto> listBookDto = (List<BookDto>) bookService.searchBook(search);
        model.addAttribute("totalPages",1);
        model.addAttribute("pageNumber",0);

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

        if (authentication != null)
        {
            Account account = accountService.getByUserName(authentication.getName());
            User user = account.getUser();
            model.addAttribute("user",user);
        }
        model.addAttribute("books",listBookDto);
        return "home";
    }

    @GetMapping("/category/{id}")
    public String getBookByCategory(Model model,
                                    Authentication authentication,
                                    @PathVariable String id,
                                    @RequestParam(name = "sort_by", required = false) String sortBy,
                                    @RequestParam(name = "type_sort", required = false) String typeSort
        ){
        List<CategoryDto> category = (List<CategoryDto>) categoryService.getAll();
        model.addAttribute("category",category);
        List<BookDto> listBookDto = (List<BookDto>) bookService.getByCategory(id);
        model.addAttribute("totalPages",1);
        model.addAttribute("pageNumber",0);
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
        if (authentication != null)
        {
            Account account = accountService.getByUserName(authentication.getName());
            User user = account.getUser();
            model.addAttribute("user",user);
        }
        model.addAttribute("books",listBookDto);
        return "home";
    }

}
