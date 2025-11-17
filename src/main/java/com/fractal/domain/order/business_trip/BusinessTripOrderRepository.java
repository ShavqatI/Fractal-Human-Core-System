package com.fractal.domain.order.business_trip;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessTripOrderRepository extends JpaRepository<BusinessTripOrder, Long> {


}
