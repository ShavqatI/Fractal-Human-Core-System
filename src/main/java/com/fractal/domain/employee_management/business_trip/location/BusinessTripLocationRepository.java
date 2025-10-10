package com.fractal.domain.employee_management.business_trip.location;

import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface BusinessTripLocationRepository extends JpaRepository<BusinessTripLocation,Long> {

  List<BusinessTripLocation> findAllByBusinessTripId(Long businessTripId);
  Optional<BusinessTripLocation> findByBusinessTripIdAndId(Long businessTripId, Long id);

}
