package com.fractal.domain.learning_develpment.learning;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LearningRepository extends JpaRepository<Learning, Long> {

}
