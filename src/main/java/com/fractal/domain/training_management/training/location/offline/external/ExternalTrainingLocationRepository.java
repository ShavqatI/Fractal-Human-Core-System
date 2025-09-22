package com.fractal.domain.training_management.training.location.offline.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface ExternalTrainingLocationRepository extends JpaRepository<ExternalTrainingLocation,Long> {

  List<ExternalTrainingLocation> findAllByTrainingId(Long trainerId);
  Optional<ExternalTrainingLocation> findByTrainingIdAndId(Long trainerId,Long id);

}
