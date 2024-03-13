package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.OrderDetailDto;
import bookstore.app.book.entity.OrderDetail;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class OrderDetailMapper extends AbstractDtoMapperAdapter<OrderDetail, OrderDetailDto> {
    public OrderDetailMapper(Class<OrderDetail> classParameter, Class<OrderDetailDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
