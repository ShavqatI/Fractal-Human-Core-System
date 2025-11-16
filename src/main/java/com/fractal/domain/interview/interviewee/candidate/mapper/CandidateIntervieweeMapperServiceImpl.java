package com.fractal.domain.interview.interviewee.candidate.mapper;

import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.interviewee.candidate.CandidateInterviewee;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.contact.mapper.CandidateContactMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class CandidateIntervieweeMapperServiceImpl implements CandidateIntervieweeMapperService {

    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final StatusService statusService;
    private final CandidateContactMapperService contactMapperService;
    private final CandidateService candidateService;

    @Override
    public IntervieweeResponse toDTO(CandidateInterviewee interviewee) {
        return new IntervieweeResponse(
                interviewee.getId(),
                interviewee.getCandidate().getLastName(),
                interviewee.getCandidate().getFirstName(),
                interviewee.getCandidate().getPatronymicName(),
                interviewee.getCandidate().getBirthDate(),
                interviewee.getCandidate().getTin(),
                interviewee.getCandidate().getSsn(),
                genderService.toDTO(interviewee.getCandidate().getGender()),
                maritalStatusService.toDTO(interviewee.getCandidate().getMaritalStatus()),
                nationalityService.toDTO(interviewee.getCandidate().getNationality()),
                Optional.ofNullable(interviewee.getCandidate().getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(interviewee.getStatus()),
                interviewee.getCreatedDate()

        );
    }

    @Override
    public IntervieweeCompactResponse toCompactDTO(CandidateInterviewee interviewee) {
        return new IntervieweeCompactResponse(
                interviewee.getId(),
                interviewee.getCandidate().getLastName(),
                interviewee.getCandidate().getFirstName(),
                interviewee.getCandidate().getPatronymicName()
        );
    }

    @Override
    public CandidateInterviewee toEntity(CandidateIntervieweeRequest dto) {
        return mapToEntity(new CandidateInterviewee(), dto);
    }

    @Override
    public CandidateInterviewee toEntity(CandidateInterviewee interviewee, CandidateIntervieweeRequest dto) {
        return mapToEntity(interviewee, dto);
    }


    private CandidateInterviewee mapToEntity(CandidateInterviewee interviewee, CandidateIntervieweeRequest dto) {
        interviewee.setCandidate(candidateService.getById(dto.candidateId()));
        interviewee.setScheduledTime(dto.scheduledTime());
        interviewee.setDurationMinutes(dto.durationMinutes());
        interviewee.setStatus(statusService.getById(dto.statusId()));
        return interviewee;
    }


}
