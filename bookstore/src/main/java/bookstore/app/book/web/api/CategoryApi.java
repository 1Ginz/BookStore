package bookstore.app.book.web.api;


import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryApi {

    private final ICategoryService categoryService;

    public CategoryApi(ICategoryService categoryService){
        this.categoryService = categoryService;
    }



    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        try {
            CategoryDto newCategory = categoryService.create(categoryDto);
            return ResponseEntity.ok().body(newCategory);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("khong upload duoc");
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        List<CategoryDto> categoryDtos = (List<CategoryDto>) categoryService.getAll();
        return ResponseEntity.ok().body(categoryDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id){
        Map<String,String> message = new HashMap<>();
        try {
            categoryService.deleteById(Long.valueOf(id));
            message.put("message","success");
            return ResponseEntity.ok(message);
        } catch (Exception e){
            e.printStackTrace();
            message.put("message","failed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){
        CategoryDto categoryDto = categoryService.getById(id);
        if (categoryDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<CategoryDto> putCategory(@PathVariable Long id,
                              @RequestBody CategoryDto categoryDto){
        try {
            CategoryDto category = categoryService.create(categoryDto);
            return ResponseEntity.ok().body(category);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}

