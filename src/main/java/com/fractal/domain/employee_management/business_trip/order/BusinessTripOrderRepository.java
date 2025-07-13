package com.fractal.domain.employee_management.business_trip.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessTripOrderRepository extends JpaRepository<BusinessTripOrder,Long> {

    List<BusinessTripOrder> findAllByBusinessTripId(Long businessTrip);
    Optional<BusinessTripOrder> findByBusinessTripIdAndId(Long businessTrip,Long id);
}
