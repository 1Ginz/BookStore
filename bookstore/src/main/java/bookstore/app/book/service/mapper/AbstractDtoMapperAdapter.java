package bookstore.app.book.service.mapper;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class AbstractDtoMapperAdapter<T1,T2> implements IConverterDto<T1,T2> {

    private Class<T1> classParameter;
    private Class<T2> classDtoParameter;

    private ModelMapper modelMapper;

    public AbstractDtoMapperAdapter(Class<T1> classParameter, Class<T2> classDtoParameter) {
        this.classParameter = classParameter;
        this.classDtoParameter = classDtoParameter;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public T1 convertToEntity(T2 dto) {
        return dto == null ? null : modelMapper.map(dto,classParameter);
    }

    @Override
    public T2 convertToDto(T1 entity) {
        return entity == null ? null : modelMapper.map(entity,classDtoParameter);
    }

    @Override
    public Collection<T1> convertToListEntity(Collection<T2> collection) {
        return collection.stream()
                .map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public Collection<T2> convertToListDto(Collection<T1> collection) {
        return collection.stream()
                .map(entity -> convertToDto(entity)).collect(Collectors.toList());
    }
}
