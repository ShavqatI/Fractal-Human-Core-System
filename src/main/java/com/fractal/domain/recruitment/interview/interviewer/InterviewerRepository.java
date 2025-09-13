package com.fractal.domain.recruitment.interview.interviewer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewerRepository extends JpaRepository<Interviewer,Long> {

    Optional<Interviewer> findByInterviewIdAndId(Long interviewId, Long id);

    List<Interviewer> findAllByInterviewId(Long interviewId);
}
