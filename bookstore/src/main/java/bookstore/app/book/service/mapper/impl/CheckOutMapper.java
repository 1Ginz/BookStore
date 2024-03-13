package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.CheckoutDto;
import bookstore.app.book.entity.Checkout;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class CheckOutMapper extends AbstractDtoMapperAdapter<Checkout, CheckoutDto> {
    public CheckOutMapper(Class<Checkout> classParameter, Class<CheckoutDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
