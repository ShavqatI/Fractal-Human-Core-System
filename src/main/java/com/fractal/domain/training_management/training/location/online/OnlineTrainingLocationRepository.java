package com.fractal.domain.training_management.training.location.online;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OnlineTrainingLocationRepository extends JpaRepository<OnlineTrainingLocation,Long> {

  List<OnlineTrainingLocation> findAllByTrainingId(Long trainerId);
  Optional<OnlineTrainingLocation> findByTrainingIdAndId(Long trainerId, Long id);

}
