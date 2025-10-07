package com.fractal.domain.employment.internal.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InternalEmploymentOrderRepository extends JpaRepository<InternalEmploymentOrder,Long> {

    List<InternalEmploymentOrder> findAllByInternalEmploymentId(Long employmentId);
    Optional<InternalEmploymentOrder> findByInternalEmploymentIdAndId(Long employmentId, Long id);
}
