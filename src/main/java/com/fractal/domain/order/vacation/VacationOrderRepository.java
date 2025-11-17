package com.fractal.domain.order.vacation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacationOrderRepository extends JpaRepository<VacationOrder, Long> {

    List<VacationOrder> findAllByVacationId(Long vacationId);

    Optional<VacationOrder> findByVacationIdAndId(Long vacationId, Long id);
}
