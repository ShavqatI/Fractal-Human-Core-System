package com.fractal.domain.training_management.training;

import com.fractal.domain.testing.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TrainingRepository extends JpaRepository<Training,Long> {

}
