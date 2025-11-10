package com.fractal.domain.interview.interviewee;

import com.fractal.domain.interview.interviewee.employee.EmployeeInterviewee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface IntervieweeRepository extends JpaRepository<Interviewee,Long> {
    Interviewee findByInterviewIdAndId(Long interviewId, Long id);
}
