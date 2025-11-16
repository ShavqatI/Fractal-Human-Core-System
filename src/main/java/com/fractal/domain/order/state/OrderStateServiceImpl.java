package com.fractal.domain.order.state;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.Order;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OrderStateServiceImpl implements OrderStateService {

    private final OrderStateRepository stateRepository;
    private final StatusService statusService;

    @Override
    public OrderState create(Order order) {
        var state = OrderState.builder()
                .order(order)
                .status(order.getStatus())
                .build();
        return save(state);
    }

    @Override
    public List<OrderState> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public OrderState getById(Long id) {
        return findById(id);
    }

    @Override
    public List<OrderState> getAllByOrderId(Long orderId) {
        return stateRepository.findAllByOrderId(orderId);
    }

    @Override
    public OrderState update(Long id, Order order) {
        try {
            OrderState state = findById(id);
            state.setOrder(order);
            state.setStatus(order.getStatus());
            return save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        stateRepository.delete(findById(id));
    }

    public OrderStateResponse toDTO(OrderState state) {
        return new OrderStateResponse(
                state.getId(),
                statusService.toCompactDTO(state.getStatus()),
                state.getCreatedDate()
        );
    }

    @Override
    public OrderState save(OrderState state) {
        try {
            return stateRepository.save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrderState findById(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
