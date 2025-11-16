package com.fractal.domain.interview.interviewee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IntervieweeRepository extends JpaRepository<Interviewee, Long> {
    Interviewee findByInterviewIdAndId(Long interviewId, Long id);
}
