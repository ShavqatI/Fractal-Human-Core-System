package com.fractal.domain.employee_management.business_trip.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface BusinessTripTypeRepository extends JpaRepository<BusinessTripType, Long> {
    Optional<BusinessTripType> findByCode(String code);

}
