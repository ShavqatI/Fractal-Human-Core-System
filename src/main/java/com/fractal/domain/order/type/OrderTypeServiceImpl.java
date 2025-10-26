package com.fractal.domain.order.type;

import com.fractal.domain.order.type.dto.OrderTypeRequest;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderTypeServiceImpl implements OrderTypeService {

    private final OrderTypeRepository orderTypeRepository;

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
        return orderTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Vacation Type with code: " + code + " not found"));

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
            orderType.setTemplateFileUrl(dto.templateFileUrl());
            orderType.setTemplateFileFormat(dto.templateFileFormat());
            return save(orderType);
        }
        catch (DataAccessException e) {
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
                orderType.getTemplateFileUrl(),
                orderType.getTemplateFileFormat(),
                orderType.getCreatedDate()
        );
    }

    private OrderType toEntity(OrderTypeRequest dto) {
        return OrderType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .series(dto.series())
                .templateFileUrl(dto.templateFileUrl())
                .templateFileFormat(dto.templateFileFormat())
                .build();
    }

    private OrderType save(OrderType orderType) {
        try {
            return orderTypeRepository.save(orderType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrderType findById(Long id) {
        return orderTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vacation Type with id: " + id + " not found"));
    }

}
