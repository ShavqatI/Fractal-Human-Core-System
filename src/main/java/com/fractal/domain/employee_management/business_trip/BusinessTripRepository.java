package com.fractal.domain.employee_management.business_trip;

import com.fractal.domain.order.business_trip.BusinessTripOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface BusinessTripRepository extends JpaRepository<BusinessTrip, Long> {

    List<BusinessTrip> findAllByEmployeeId(Long employeeId);

    @Query("""
    select bto from BusinessTripOrder bto
    join bto.records record
    where record.businessTrip.id = :id
    
""")
    Optional<BusinessTripOrder> findOrder(Long id);

}
