//package bookstore.app.book.web.controller;
//
//
//import bookstore.app.book.dto.CategoryDto;
//import bookstore.app.book.service.ICategoryService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RequestMapping("/category")
//@Controller
//public class CategoryController {
//
//    private final ICategoryService categoryService;
//
//    public CategoryController(ICategoryService categoryService){
//        this.categoryService = categoryService;
//    }
//
//    @GetMapping("/add")
//    public String getCategory(Model model){
//        CategoryDto categoryDto = categoryService.getById((long) -1);
//        model.addAttribute("category",categoryDto);
//        return "add-category";
//    }
//
//    @PostMapping("/add")
//    public String addCategory(@ModelAttribute("category") CategoryDto categoryDto){
//        try {
//            categoryService.create(categoryDto);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }
//
//
//}
