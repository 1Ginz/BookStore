package bookstore.app.book.service.impl;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CommentDto;
import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.Comment;
import bookstore.app.book.repository.CommentRepository;
import bookstore.app.book.service.ICommentService;
import bookstore.app.book.service.mapper.IConverterDto;
import bookstore.app.book.service.mapper.impl.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    @Qualifier("commentMapper")
    private IConverterDto<Comment, CommentDto> commentMapper;

    @Override
    public CommentDto create(CommentDto dto) throws Exception {
        Comment comment = commentRepository.save(commentMapper.convertToEntity(dto));
        CommentDto commentDto = commentMapper.convertToDto(comment);
        return commentDto;
    }

    @Override
    public CommentDto update(Long id, CommentDto dto) throws Exception {
        Comment comment = commentRepository.getById(id);
        if(comment == null){
            throw new Exception("comment not found");
        }
        comment = commentRepository.save(commentMapper.convertToEntity(dto));
        CommentDto commentDto = commentMapper.convertToDto(comment);
        return commentDto;
    }

    @Override
    public CommentDto getById(Long id) {
        return commentMapper.convertToDto(commentRepository.getById(id));
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        commentRepository.deleteById(id);
        return true;
    }

    @Override
    public Collection<CommentDto> getAll() {
        return commentMapper.convertToListDto(commentRepository.findAll());
    }

    @Override
    public Page<CommentDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CommentDto> getByBook(Long bookId) {
        List<Comment> commentList = commentRepository.findByBookIdOrderByIdDesc(bookId);
        List<CommentDto> commentDtoList = (List<CommentDto>) commentMapper.convertToListDto(commentList);
        return commentDtoList;
    }
}
