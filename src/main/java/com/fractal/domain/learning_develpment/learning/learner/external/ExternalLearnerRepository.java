package com.fractal.domain.learning_develpment.learning.learner.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExternalLearnerRepository extends JpaRepository<ExternalLearner, Long> {

}
