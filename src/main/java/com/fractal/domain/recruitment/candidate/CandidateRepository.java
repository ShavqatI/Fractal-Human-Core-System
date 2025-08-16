package com.fractal.domain.recruitment.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CandidateRepository extends JpaRepository<Candidate,Long> {

}
