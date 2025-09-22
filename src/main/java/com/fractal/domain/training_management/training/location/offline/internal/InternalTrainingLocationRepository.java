package com.fractal.domain.training_management.training.location.offline.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InternalTrainingLocationRepository extends JpaRepository<InternalTrainingLocation,Long> {

  List<InternalTrainingLocation> findAllByTrainingId(Long trainerId);
  Optional<InternalTrainingLocation> findByTrainingIdAndId(Long trainerId,Long id);

}
