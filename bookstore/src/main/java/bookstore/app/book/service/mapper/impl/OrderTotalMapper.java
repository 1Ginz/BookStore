package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.OrderTotalDto;
import bookstore.app.book.entity.OrderTotal;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class OrderTotalMapper extends AbstractDtoMapperAdapter<OrderTotal, OrderTotalDto> {
    public OrderTotalMapper(Class<OrderTotal> classParameter, Class<OrderTotalDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
