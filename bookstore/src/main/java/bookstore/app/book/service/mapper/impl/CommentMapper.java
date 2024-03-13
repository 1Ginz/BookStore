package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.CommentDto;
import bookstore.app.book.entity.Comment;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class CommentMapper extends AbstractDtoMapperAdapter<Comment, CommentDto> {
    public CommentMapper(Class<Comment> classParameter, Class<CommentDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
