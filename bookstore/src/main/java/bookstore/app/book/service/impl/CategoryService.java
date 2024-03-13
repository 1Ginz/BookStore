package bookstore.app.book.service.impl;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.entity.Category;
import bookstore.app.book.repository.CategoryRepository;
import bookstore.app.book.service.ICategoryService;
import bookstore.app.book.service.mapper.IConverterDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;
    private final IConverterDto<Category,CategoryDto> categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           @Qualifier("categoryMapper") IConverterDto<Category,CategoryDto> categoryMapper
    ){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto create(CategoryDto dto) throws Exception {
        Category category = categoryRepository.save(categoryMapper.convertToEntity(dto));
        return categoryMapper.convertToDto(category);
    }

    @Override
    public CategoryDto update(Long id, CategoryDto dto) throws Exception {
        if(categoryRepository.existsById(id)){
            Category category = categoryRepository.save(categoryMapper.convertToEntity(dto));
            return categoryMapper.convertToDto(category);
        }
        return null;
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
//            CategoryDto categoryDto = new CategoryDto();
//            categoryDto.setId((long) -1);
            return null;
        }
        return categoryMapper.convertToDto(category);
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        if (!categoryRepository.existsById(id)){
            throw new Exception("ko tim thay id");
        }
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<CategoryDto> getAll() {
        return (List<CategoryDto>) categoryMapper.convertToListDto(categoryRepository.findAll());
    }

    @Override
    public Page<CategoryDto> getAll(Pageable pageable) {
        return null;
    }

}
