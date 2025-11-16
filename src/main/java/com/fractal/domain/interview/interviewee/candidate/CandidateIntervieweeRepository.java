package com.fractal.domain.interview.interviewee.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateIntervieweeRepository extends JpaRepository<CandidateInterviewee, Long> {

    Optional<CandidateInterviewee> findByInterviewIdAndId(Long interviewId, Long id);

    List<CandidateInterviewee> findAllByInterviewId(Long interviewId);
}
