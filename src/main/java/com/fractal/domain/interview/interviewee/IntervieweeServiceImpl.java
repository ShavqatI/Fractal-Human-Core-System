package com.fractal.domain.interview.interviewee;

import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.mapper.IntervieweeMapperService;
import com.fractal.domain.interview.InterviewService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class IntervieweeServiceImpl implements IntervieweeService {

    private final IntervieweeRepository intervieweeRepository;
    private final IntervieweeMapperService mapperService;
    private final InterviewService interviewService;

    @Override
    public Interviewee create(Long interviewId, IntervieweeRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewee = mapperService.toEntity(dto);
        interview.addInterviewee(interviewee);
        interviewService.save(interview);
        return interviewee;
    }

    @Override
    public List<Interviewee> getAllByInterviewId(Long interviewerId) {
        return intervieweeRepository.findAllByInterviewId(interviewerId);
    }

    @Override
    public Interviewee getById(Long interviewId, Long id) {
        return intervieweeRepository.findByInterviewIdAndId(interviewId,id).orElseThrow(()->new ResourceNotFoundException("Interviewee with id: " + id + " not found"));
    }



    @Override
    public Interviewee update(Long interviewId, Long id, IntervieweeRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewee = interview.getInterviewees()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interviewee with id: " + id + " not found"));
        interviewee = intervieweeRepository.save(mapperService.toEntity(interviewee,dto));
        interviewService.save(interview);
        return interviewee;
    }

    @Override
    public void delete(Long interviewId, Long id) {
        var interview = interviewService.getById(interviewId);
        var interviewee = interview.getInterviewees()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interviewee with id: " + id + " not found"));
        interview.removeInterviewee(interviewee);
        interviewService.save(interview);
    }



    @Override
    public IntervieweeResponse toDTO(Interviewee interviewee) {
        return mapperService.toDTO(interviewee);
    }
}
