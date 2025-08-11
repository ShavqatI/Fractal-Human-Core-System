package com.fractal.domain.recruitment.candidate.citizenship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateCitizenshipRepository extends JpaRepository<CandidateCitizenship,Long> {


}
