package bookstore.app.book.service.mapper.impl;

import bookstore.app.book.dto.CheckOutDetailDto;
import bookstore.app.book.entity.CheckoutDetail;
import bookstore.app.book.service.mapper.AbstractDtoMapperAdapter;

public class CheckOutDetailMapper extends AbstractDtoMapperAdapter<CheckoutDetail, CheckOutDetailDto> {
    public CheckOutDetailMapper(Class<CheckoutDetail> classParameter, Class<CheckOutDetailDto> classDtoParameter) {
        super(classParameter, classDtoParameter);
    }
}
