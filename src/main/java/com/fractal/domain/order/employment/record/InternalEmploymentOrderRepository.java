package com.fractal.domain.order.employment.record;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InternalEmploymentOrderRepository extends JpaRepository<InternalEmploymentOrderRecord, Long> {

    List<InternalEmploymentOrderRecord> findAllByInternalEmploymentOrderId(Long orderId);

    Optional<InternalEmploymentOrderRecord> findByInternalEmploymentOrderIdAndId(Long orderId, Long id);
}
