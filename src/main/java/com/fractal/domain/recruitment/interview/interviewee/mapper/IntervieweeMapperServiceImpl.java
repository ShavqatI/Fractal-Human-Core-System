package com.fractal.domain.recruitment.interview.interviewee.mapper;

import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.dto.InterviewResponse;
import com.fractal.domain.recruitment.interview.interviewee.Interviewee;
import com.fractal.domain.recruitment.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.recruitment.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.recruitment.interview.interviewer.Interviewer;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class IntervieweeMapperServiceImpl implements IntervieweeMapperService {


    @Override
    public IntervieweeResponse toDTO(Interviewee interviewee) {
        return null;
    }

    @Override
    public Interviewee toEntity(IntervieweeRequest dto) {
        return null;
    }

    @Override
    public Interviewee toEntity(Interviewee interviewee, IntervieweeRequest dto) {
        return null;
    }
}
