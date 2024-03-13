package bookstore.app.book.web.MVC.admin;

import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    private final ICategoryService categoryService;

    public AdminCategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String getAddCategory(Model model){
        CategoryDto categoryDto = categoryService.getById((long) -1);
        model.addAttribute("category",categoryDto);
        return "add-category";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") CategoryDto categoryDto){
        try {
            categoryService.create(categoryDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/category/";
    }

    @GetMapping("/")
    public String getCategories(Model model){
        List<CategoryDto> categoryDtos = (List<CategoryDto>) categoryService.getAll();
        model.addAttribute("categories", categoryDtos);
        return "admin-category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable String id, Model model){
        try {
            categoryService.deleteById(Long.valueOf(id));
            return "redirect:/admin/category/";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/category/";
    }

    @GetMapping("/{id}")
    public String getCategory(@PathVariable Long id,
                              Model model){
        CategoryDto categoryDto = categoryService.getById(id);
        model.addAttribute("category",categoryDto);
        return "admin-category-details";
    }

    @PutMapping ("/{id}")
    public String putCategory(@PathVariable Long id,
                              @ModelAttribute("category") CategoryDto categoryDto){
        try {
            categoryService.create(categoryDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/category/";
    }

}
