package bookstore.app.book.service.impl;

import bookstore.app.book.dto.OrderDetailDto;
import bookstore.app.book.entity.OrderDetail;
import bookstore.app.book.repository.OrderDetailRepository;
import bookstore.app.book.service.IOrderDetailService;
import bookstore.app.book.service.mapper.IConverterDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

public class OrderDetailService implements IOrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final IConverterDto<OrderDetail,OrderDetailDto> mapper;

    public OrderDetailService(OrderDetailRepository orderDetailRepository,
                              @Qualifier("OrderDetailMapper")IConverterDto<OrderDetail,OrderDetailDto> mapper){
        this.orderDetailRepository = orderDetailRepository;
        this.mapper = mapper;
    }

    @Override
    public OrderDetailDto create(OrderDetailDto dto) throws Exception {
        return null;
    }

    @Override
    public OrderDetailDto update(Long id, OrderDetailDto dto) throws Exception {
        return null;
    }

    @Override
    public OrderDetailDto getById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws Exception {
        return false;
    }

    @Override
    public Collection<OrderDetailDto> getAll() {
        return null;
    }

    @Override
    public Page<OrderDetailDto> getAll(Pageable pageable) {
        return null;
    }
}
