package com.fractal.domain.order.employment.record;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmploymentOrderRecordRepository extends JpaRepository<EmploymentOrderRecord, Long> {

    List<EmploymentOrderRecord> findAllByEmploymentOrderId(Long orderId);

    Optional<EmploymentOrderRecord> findByEmploymentOrderIdAndId(Long orderId, Long id);
}
