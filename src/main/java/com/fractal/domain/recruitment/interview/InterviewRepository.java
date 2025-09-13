package com.fractal.domain.recruitment.interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InterviewRepository extends JpaRepository<Interview,Long> {

}
