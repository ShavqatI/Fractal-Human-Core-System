package com.fractal.domain.interview.interviewee.candidate.mapper;

import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.candidate.CandidateInterviewee;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.mapper.IntervieweeMapperService;

public interface CandidateIntervieweeMapperService extends IntervieweeMapperService {
    IntervieweeResponse toDTO(Interviewee interviewee);
    IntervieweeCompactResponse toCompactDTO(CandidateInterviewee interviewee);
    CandidateInterviewee toEntity(CandidateIntervieweeRequest dto);
    CandidateInterviewee toEntity(CandidateInterviewee interviewee, CandidateIntervieweeRequest dto);
}


