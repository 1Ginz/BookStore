package bookstore.app.book.service.impl;

import bookstore.app.book.dto.BookDto;
import bookstore.app.book.dto.CategoryDto;
import bookstore.app.book.entity.Book;
import bookstore.app.book.entity.Category;
import bookstore.app.book.repository.BookRepository;
import bookstore.app.book.repository.CategoryRepository;
import bookstore.app.book.service.IBookService;
import bookstore.app.book.service.mapper.IConverterDto;
import bookstore.app.book.service.mapper.impl.CategoryMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service("bookservice")
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    private final IConverterDto<Book, BookDto> bookMapper;

    private final CategoryRepository categoryRepository;



    public BookService(BookRepository bookRepository,
                       @Qualifier("bookMapper") IConverterDto<Book, BookDto> bookMapper,
                       CategoryRepository categoryRepository){
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<BookDto> getAll(){
        return (List<BookDto>) bookMapper.convertToListDto(bookRepository.findAll());
    }

    @Override
    public Page<BookDto> getAll(Pageable pageable){
        Page<Book> bookPage = bookRepository.findAll(pageable);
        List<BookDto> bookDtoList = (List<BookDto>) bookMapper.convertToListDto(bookPage.getContent());
        return new PageImpl<BookDto>(bookDtoList, pageable, bookPage.getTotalElements());

    }

//    public List<BookDto> getAllBookBySort(String sortBy,String typeSort){
//        if (sortBy == null) return (List<BookDto>) bookMapper.convertToListDto(bookRepository.findAll());
//        Sort sort;
//        if(typeSort.equals("ASC")){
//            sort = Sort.by(Sort.Direction.ASC,sortBy);
//        }else{
//            sort = Sort.by(Sort.Direction.DESC,sortBy);
//        }
//        return (List<BookDto>) bookMapper.convertToListDto(bookRepository.findAll(sort));
//    }

    @Override
    public BookDto getById(Long id){
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null){
            BookDto bookDto = new BookDto();
            bookDto.setId((long) -1);
            return bookDto;
        }
        return (BookDto) bookMapper.convertToDto(book);
    }

    @Override
    public List<BookDto> getByCategory(String id){
        Category category = categoryRepository.getById(Long.valueOf(id));
        return (List<BookDto>) bookMapper.convertToListDto(bookRepository.findByCategory(category));
    }


    @Override
    public BookDto create(BookDto bookDto){
        Book book = bookMapper.convertToEntity(bookDto);
        Book result = bookRepository.save(book);
        bookDto = bookMapper.convertToDto(result);
        return bookDto;
    }

    @Override
    public BookDto update(Long id, BookDto book){
        if (!bookRepository.existsById(id)){
            create(book);
            return book;
        }
        StringBuilder newAvatar = new StringBuilder("/data/book/");
        newAvatar.append(book.getId());
        newAvatar.append("/");
        newAvatar.append(book.getImgCover());
        book.setImgCover(newAvatar.toString());
        System.out.println(book.getImgCover());
        bookRepository.save(bookMapper.convertToEntity(book));
        return book;
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        if(!bookRepository.existsById(id)){
            throw new Exception("ko tim thay de xoa");
        }
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public List<BookDto> searchBook(String param){
       Set<Book> total = bookRepository.searchBook(param);
       return (List<BookDto>) bookMapper.convertToListDto(total);
    }

    private void UploadImage(MultipartFile multipartFile){

    }


}
