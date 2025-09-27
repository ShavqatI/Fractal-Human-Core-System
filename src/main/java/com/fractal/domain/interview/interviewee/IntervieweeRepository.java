package com.fractal.domain.interview.interviewee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface IntervieweeRepository extends JpaRepository<Interviewee,Long> {

    Optional<Interviewee> findByInterviewIdAndId(Long interviewId, Long id);

    List<Interviewee> findAllByInterviewId(Long interviewId);
}
