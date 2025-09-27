package com.fractal.domain.interview.interviewee.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class IntervieweeMapperServiceImpl implements IntervieweeMapperService {
     private final StatusService statusService;
     private final CandidateService candidateService;

    @Override
    public IntervieweeResponse toDTO(Interviewee interviewee) {
        return new IntervieweeResponse(
                interviewee.getId(),
                candidateService.toCompactDTO(interviewee.getCandidate()),
                interviewee.getScheduledTime(),
                interviewee.getDurationMinutes(),
                statusService.toCompactDTO(interviewee.getStatus()),
                interviewee.getCreatedDate()
        );
    }

    @Override
    public Interviewee toEntity(IntervieweeRequest dto) {
        return mapToEntity(new Interviewee(),dto);
    }

    @Override
    public Interviewee toEntity(Interviewee interviewee, IntervieweeRequest dto) {
        return mapToEntity(interviewee,dto);
    }
    private Interviewee mapToEntity(Interviewee interviewee , IntervieweeRequest dto) {
        interviewee.setCandidate(candidateService.getById(dto.candidateId()));
        interviewee.setScheduledTime(dto.scheduledTime());
        interviewee.setDurationMinutes(dto.durationMinutes());
        interviewee.setStatus(statusService.getById(dto.statusId()));
        return interviewee;

    }
}

