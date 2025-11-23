package com.fractal.domain.order.business_trip;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessTripOrderRepository extends JpaRepository<BusinessTripOrder, Long> {


}
