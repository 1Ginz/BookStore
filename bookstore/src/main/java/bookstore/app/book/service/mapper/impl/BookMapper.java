package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.entity.Book;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class BookMapper extends AbstractDtoMapperAdapter<Book, BookDto> {
    public BookMapper(Class<Book> classParameter, Class<BookDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
