package com.fractal.domain.interview.interviewee.candidate;

import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;

import java.util.List;

public interface CandidateIntervieweeService {

    Interviewee create(Long interviewId, CandidateIntervieweeRequest dto);
    Interviewee update(Long interviewId, Long id, CandidateIntervieweeRequest dto);
    List<CandidateInterviewee> getAllByInterviewId(Long interviewerId);
    Interviewee getById(Long interviewId , Long id);
    void delete(Long interviewId, Long id);
    IntervieweeResponse toDTO(CandidateInterviewee interviewee);
    IntervieweeCompactResponse toCompactDTO(CandidateInterviewee interviewee);
}
