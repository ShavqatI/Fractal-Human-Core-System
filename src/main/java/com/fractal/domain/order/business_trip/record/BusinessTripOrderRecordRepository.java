package com.fractal.domain.order.business_trip.record;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessTripOrderRecordRepository extends JpaRepository<BusinessTripOrderRecord, Long> {

    List<BusinessTripOrderRecord> findAllByBusinessTripOrderId(Long orderId);

    Optional<BusinessTripOrderRecord> findByBusinessTripOrderIdAndId(Long orderId, Long id);
}
