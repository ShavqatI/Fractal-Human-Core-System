package com.fractal.domain.learning_develpment.learning.learner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LearnerRepository extends JpaRepository<Learner, Long> {

}
