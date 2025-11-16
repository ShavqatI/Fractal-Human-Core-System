package com.fractal.domain.interview.interviewer;

import com.fractal.domain.interview.InterviewService;
import com.fractal.domain.interview.interviewer.dto.InterviewerRequest;
import com.fractal.domain.interview.interviewer.dto.InterviewerResponse;
import com.fractal.domain.interview.interviewer.mapper.InterviewerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewerServiceImpl implements InterviewerService {

    private final InterviewerRepository interviewerRepository;
    private final InterviewerMapperService mapperService;
    private final InterviewService interviewService;

    @Override
    public Interviewer create(Long interviewId, InterviewerRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewer = mapperService.toEntity(dto);
        interview.addInterviewer(interviewer);
        interviewService.save(interview);
        return interviewer;
    }

    @Override
    public List<Interviewer> getAllByInterviewId(Long interviewerId) {
        return interviewerRepository.findAllByInterviewId(interviewerId);
    }

    @Override
    public Interviewer getById(Long interviewId, Long id) {
        return interviewerRepository.findByInterviewIdAndId(interviewId, id).orElseThrow(() -> new ResourceNotFoundException("Interviewer with id: " + id + " not found"));

    }

    @Override
    public Interviewer getById(Long id) {
        return interviewerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Interviewer with id: " + id + " not found"));
    }

    @Override
    public Interviewer update(Long interviewId, Long id, InterviewerRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewer = interview.getInterviewers()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Interviewee with id: " + id + " not found"));
        interviewer = interviewerRepository.save(mapperService.toEntity(interviewer, dto));
        interviewService.save(interview);
        return interviewer;
    }

    @Override
    public void delete(Long interviewId, Long id) {
        var interview = interviewService.getById(interviewId);
        var interviewer = interview.getInterviewers()
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Interviewee with id: " + id + " not found"));
        interview.removeInterviewer(interviewer);
        interviewService.save(interview);
    }

    @Override
    public Interviewer save(Interviewer interviewer) {
        try {
            return interviewerRepository.save(interviewer);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public InterviewerResponse toDTO(Interviewer interviewer) {
        return mapperService.toDTO(interviewer);
    }

}
