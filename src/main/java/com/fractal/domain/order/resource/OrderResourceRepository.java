package com.fractal.domain.order.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderResourceRepository extends JpaRepository<OrderResource,Long> {
    List<OrderResource> findAllByOrderId(Long educationId);
    Optional<OrderResource> findByOrderIdAndId(Long educationId, Long id);
}
