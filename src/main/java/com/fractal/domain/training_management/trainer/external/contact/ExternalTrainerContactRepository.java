package com.fractal.domain.training_management.trainer.external.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExternalTrainerContactRepository extends JpaRepository<ExternalTrainerContact,Long> {

    List<ExternalTrainerContact> findAllByExternalTrainerId(Long trainerId);
    Optional<ExternalTrainerContact> findByExternalTrainerIdAndId(Long trainerId, Long id);
}
