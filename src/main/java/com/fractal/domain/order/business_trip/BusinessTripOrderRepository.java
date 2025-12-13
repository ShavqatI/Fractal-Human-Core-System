package com.fractal.domain.order.business_trip;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessTripOrderRepository extends JpaRepository<BusinessTripOrder, Long> {

    @Query("""
    select bto from BusinessTripOrder bto
    join bto.records record
    where record.businessTrip.id = :businessTripId
    
""")
    Optional<BusinessTripOrder> findByBusinessTripId(Long businessTripId);
}
