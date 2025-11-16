package com.fractal.domain.learning_develpment.learning.learner.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InternalLearnerRepository extends JpaRepository<InternalLearner, Long> {

}
