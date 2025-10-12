package com.fractal.domain.employee_management.business_trip.location.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface BusinessTripLocationTypeRepository extends JpaRepository<BusinessTripLocationType,Long> {
    Optional<BusinessTripLocationType> findByCode(String code);

}
