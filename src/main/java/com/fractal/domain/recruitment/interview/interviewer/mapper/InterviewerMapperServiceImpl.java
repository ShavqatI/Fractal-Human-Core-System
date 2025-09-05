package com.fractal.domain.recruitment.interview.interviewer.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.interview.Interview;
import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.dto.InterviewResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.mapper.InterviewEvaluationSessionMapperService;
import com.fractal.domain.recruitment.interview.interviewer.Interviewer;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerRequest;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerResponse;
import com.fractal.domain.recruitment.interview.type.InterviewTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

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
