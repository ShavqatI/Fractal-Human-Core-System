package com.fractal.domain.order.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface OrderStateRepository extends JpaRepository<OrderState, Long> {

    List<OrderState> findAllByOrderId(Long orderId);

}
