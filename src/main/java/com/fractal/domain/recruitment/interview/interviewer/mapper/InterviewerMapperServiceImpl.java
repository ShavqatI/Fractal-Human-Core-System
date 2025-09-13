package com.fractal.domain.recruitment.interview.interviewer.mapper;

import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.interviewer.Interviewer;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerRequest;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InterviewerMapperServiceImpl implements InterviewerMapperService {


    @Override
    public InterviewerResponse toDTO(Interviewer interviewer) {
        return null;
    }

    @Override
    public Interviewer toEntity(InterviewerRequest dto) {
        return null;
    }

    @Override
    public Interviewer toEntity(Interviewer interviewer, InterviewRequest dto) {
        return null;
    }
}
