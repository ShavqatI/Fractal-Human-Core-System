package com.fractal.domain.recruitment.interview.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.interview.Interview;
import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.dto.InterviewResponse;
import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.mapper.InterviewEvaluationSectionMapperService;
import com.fractal.domain.recruitment.interview.evaluation.session.InterviewEvaluationSession;
import com.fractal.domain.recruitment.interview.evaluation.session.mapper.InterviewEvaluationSessionMapperService;
import com.fractal.domain.recruitment.interview.interviewee.mapper.IntervieweeMapperService;
import com.fractal.domain.recruitment.interview.interviewer.mapper.InterviewerMapperService;
import com.fractal.domain.recruitment.interview.type.InterviewTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewMapperServiceImpl implements InterviewMapperService {

    private final StatusService statusService;
    private final InterviewTypeService interviewTypeService;
    private final InterviewEvaluationSessionMapperService sessionMapperService;
    private final InterviewerMapperService interviewerMapperService;
    private final IntervieweeMapperService intervieweeMapperService;

    @Override
    public InterviewResponse toDTO(Interview interview) {
        return new InterviewResponse(
                interview.getId(),
                interviewTypeService.toDTO(interview.getInterviewType()),
                interview.getScheduledTime(),
                interview.getDurationMinutes(),
                interview.getDescription(),
                interview.getNotes(),
                interview.getDetails(),
                Optional.ofNullable(interview.getInterviewers())
                        .orElse(emptyList())
                        .stream()
                        .map(interviewerMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(interview.getInterviewees())
                        .orElse(emptyList())
                        .stream()
                        .map(intervieweeMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(interview.getEvaluationSessions())
                        .orElse(emptyList())
                        .stream()
                        .map(sessionMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(interview.getStatus()),
                interview.getCreatedDate()
        );
    }
    @Override
    public Interview toEntity(InterviewRequest dto) {
        return mapToEntity(new Interview(),dto);
    }

    @Override
    public Interview toEntity(Interview interview, InterviewRequest dto) {
       return mapToEntity(interview,dto);
    }

    private Interview mapToEntity(Interview interview , InterviewRequest dto) {
        interview.setInterviewType(interviewTypeService.getById(dto.interviewTypeId()));
        interview.setScheduledTime(dto.scheduledTime());
        interview.setDurationMinutes(dto.durationMinutes());
        interview.setDescription(dto.description());
        interview.setNotes(dto.notes());
        interview.setDetails(dto.details());
        dto.interviewers().forEach(interviewer-> interview.addInterviewer(interviewerMapperService.toEntity(interviewer)));
        dto.interviewees().forEach(interviewee -> interview.addInterviewee(intervieweeMapperService.toEntity(interviewee)));
        interview.setStatus(statusService.getById(dto.statusId()));
        return interview;

    }


}
