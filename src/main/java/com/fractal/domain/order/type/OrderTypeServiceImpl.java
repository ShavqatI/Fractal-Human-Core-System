package com.fractal.domain.order.type;

import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.domain.order.category.OrderCategory;
import com.fractal.domain.order.category.OrderCategoryService;
import com.fractal.domain.order.type.dto.OrderTypeRequest;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OrderTypeServiceImpl implements OrderTypeService {

    private final OrderTypeRepository orderTypeRepository;
    private final DocumentTemplateManagerService documentTemplateManagerService;
    private final OrderCategoryService orderCategoryService;

    @Override
    public OrderType create(OrderTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<OrderType> getAll() {
        return orderTypeRepository.findAll();
    }

    @Override
    public OrderType getByCode(String code) {
        return orderTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with code: " + code + " not found"));

    }

    @Override
    public OrderType getById(Long id) {
        return findById(id);
    }

    @Override
    public OrderType update(Long id, OrderTypeRequest dto) {
        try {
            OrderType orderType = findById(id);
            orderType.setCode(dto.code());
            orderType.setName(dto.name());
            orderType.setDescription(dto.description());
            orderType.setSeries(dto.series());
            orderType.setDocumentTemplateManager(documentTemplateManagerService.getById(dto.documentTemplateManagerId()));
            orderType.setOrderCategory(orderCategoryService.getById(dto.orderCategoryId()));
            return save(orderType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        orderTypeRepository.delete(findById(id));
    }

    @Override
    public OrderTypeResponse toDTO(OrderType orderType) {
        return new OrderTypeResponse(
                orderType.getId(),
                orderType.getCode(),
                orderType.getName(),
                orderType.getDescription(),
                orderType.getSeries(),
                documentTemplateManagerService.toDTO(orderType.getDocumentTemplateManager()),
                orderCategoryService.toDTO(orderType.getOrderCategory()),
                orderType.getCreatedDate()
        );
    }

    private OrderType toEntity(OrderTypeRequest dto) {
        return OrderType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .series(dto.series())
                .documentTemplateManager(documentTemplateManagerService.getById(dto.documentTemplateManagerId()))
                .orderCategory(orderCategoryService.getById(dto.orderCategoryId()))
                .build();
    }

    private OrderType save(OrderType orderType) {
        try {
            return orderTypeRepository.save(orderType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrderType findById(Long id) {
        return orderTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with id: " + id + " not found"));
    }

}
