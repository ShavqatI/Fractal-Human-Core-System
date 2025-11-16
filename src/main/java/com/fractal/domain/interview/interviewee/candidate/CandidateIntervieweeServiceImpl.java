package com.fractal.domain.interview.interviewee.candidate;

import com.fractal.domain.interview.InterviewService;
import com.fractal.domain.interview.interviewee.candidate.dto.CandidateIntervieweeRequest;
import com.fractal.domain.interview.interviewee.candidate.mapper.CandidateIntervieweeMapperService;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateIntervieweeServiceImpl implements CandidateIntervieweeService {

    private final CandidateIntervieweeRepository intervieweeRepository;
    private final CandidateIntervieweeMapperService mapperService;
    private final InterviewService interviewService;

    @Override
    public CandidateInterviewee create(Long interviewId, CandidateIntervieweeRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewee = mapperService.toEntity(dto);
        interview.addInterviewee(interviewee);
        interviewService.save(interview);
        return interviewee;
    }

    @Override
    public List<CandidateInterviewee> getAllByInterviewId(Long interviewerId) {
        return intervieweeRepository.findAllByInterviewId(interviewerId);
    }

    @Override
    public CandidateInterviewee getById(Long interviewId, Long id) {
        return intervieweeRepository.findByInterviewIdAndId(interviewId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }


    @Override
    public CandidateInterviewee update(Long interviewId, Long id, CandidateIntervieweeRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewee = (CandidateInterviewee) interview.getInterviewees()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        interviewee = intervieweeRepository.save(mapperService.toEntity(interviewee, dto));
        interviewService.save(interview);
        return interviewee;
    }

    @Override
    public void delete(Long interviewId, Long id) {
        var interview = interviewService.getById(interviewId);
        var interviewee = (CandidateInterviewee) interview.getInterviewees()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        interview.removeInterviewee(interviewee);
        interviewService.save(interview);
    }


    @Override
    public IntervieweeResponse toDTO(CandidateInterviewee interviewee) {
        return mapperService.toDTO(interviewee);
    }

    @Override
    public IntervieweeCompactResponse toCompactDTO(CandidateInterviewee interviewee) {
        return mapperService.toCompactDTO(interviewee);
    }

}
