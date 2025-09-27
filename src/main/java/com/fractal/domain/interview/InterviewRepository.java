package com.fractal.domain.interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InterviewRepository extends JpaRepository<Interview,Long> {

}
