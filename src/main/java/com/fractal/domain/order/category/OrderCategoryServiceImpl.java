package com.fractal.domain.order.category;

import com.fractal.domain.order.category.dto.OrderCategoryRequest;
import com.fractal.domain.order.category.dto.OrderCategoryResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderCategoryServiceImpl implements OrderCategoryService {

    private final OrderCategoryRepository orderCategoryRepository;

    @Override
    public OrderCategory create(OrderCategoryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<OrderCategory> getAll() {
        return orderCategoryRepository.findAll();
    }

    @Override
    public OrderCategory getByCode(String code) {
        return orderCategoryRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Vacation Category with code: " + code + " not found"));

    }

    @Override
    public OrderCategory getById(Long id) {
        return findById(id);
    }

    @Override
    public OrderCategory update(Long id, OrderCategoryRequest dto) {
        try {
            OrderCategory orderCategory = findById(id);
            orderCategory.setCode(dto.code());
            orderCategory.setName(dto.name());
            return save(orderCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        orderCategoryRepository.delete(findById(id));
    }

    @Override
    public OrderCategoryResponse toDTO(OrderCategory orderCategory) {
        return new OrderCategoryResponse(
                orderCategory.getId(),
                orderCategory.getCode(),
                orderCategory.getName(),
                orderCategory.getCreatedDate()
        );
    }

    private OrderCategory toEntity(OrderCategoryRequest dto) {
        return OrderCategory.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private OrderCategory save(OrderCategory orderCategory) {
        try {
            return orderCategoryRepository.save(orderCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrderCategory findById(Long id) {
        return orderCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation Category with id: " + id + " not found"));
    }

}
