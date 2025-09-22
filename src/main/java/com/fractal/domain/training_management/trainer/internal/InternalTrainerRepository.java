package com.fractal.domain.training_management.trainer.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InternalTrainerRepository extends JpaRepository<InternalTrainer,Long> {

}
