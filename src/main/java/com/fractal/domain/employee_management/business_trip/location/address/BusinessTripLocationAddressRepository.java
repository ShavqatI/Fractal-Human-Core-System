package com.fractal.domain.employee_management.business_trip.location.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface BusinessTripLocationAddressRepository extends JpaRepository<BusinessTripLocationAddress, Long> {
    List<BusinessTripLocationAddress> findAllByBusinessTripLocationId(Long locationId);
    Optional<BusinessTripLocationAddress> findByBusinessTripLocationIdAndId(Long locationId, Long id);
}
