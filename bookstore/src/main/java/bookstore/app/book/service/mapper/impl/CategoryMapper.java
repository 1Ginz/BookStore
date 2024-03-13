package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.entity.Category;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class CategoryMapper extends AbstractDtoMapperAdapter<Category, CategoryDto> {
    public CategoryMapper(Class<Category> classParameter, Class<CategoryDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
