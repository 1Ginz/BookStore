package bookstore.app.book.service.mapper;

import java.util.Collection;

public interface IConverterDto <T1,T2>{
    T1 convertToEntity(T2 dto);
    T2 convertToDto(T1 entity);
    Collection<T1> convertToListEntity(Collection<T2> collection);
    Collection<T2> convertToListDto(Collection<T1> collection);
}
