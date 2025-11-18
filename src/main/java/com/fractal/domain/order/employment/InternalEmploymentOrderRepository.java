package com.fractal.domain.order.employment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalEmploymentOrderRepository extends JpaRepository<InternalEmploymentOrder, Long> {


}
