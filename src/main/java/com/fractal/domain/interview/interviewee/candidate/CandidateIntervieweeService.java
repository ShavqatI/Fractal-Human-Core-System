package com.fractal.domain.interview.interviewee.candidate;


import com.fractal.domain.interview.interviewee.IntervieweeService;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
public interface CandidateIntervieweeService extends IntervieweeService {

    CandidateInterviewee create(Long interviewId, CandidateIntervieweeRequest dto);
    CandidateInterviewee update(Long interviewId, Long id, CandidateIntervieweeRequest dto);
}
