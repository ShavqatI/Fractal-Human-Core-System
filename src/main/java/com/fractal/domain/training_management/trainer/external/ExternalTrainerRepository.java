package com.fractal.domain.training_management.trainer.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExternalTrainerRepository extends JpaRepository<ExternalTrainer,Long> {

}
