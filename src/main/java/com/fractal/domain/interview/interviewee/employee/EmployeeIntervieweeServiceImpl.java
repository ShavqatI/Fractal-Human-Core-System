package com.fractal.domain.interview.interviewee.employee;

import com.fractal.domain.interview.InterviewService;
import com.fractal.domain.interview.interviewee.Interviewee;
import com.fractal.domain.interview.interviewee.dto.IntervieweeCompactResponse;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import com.fractal.domain.interview.interviewee.employee.dto.EmployeeIntervieweeRequest;
import com.fractal.domain.interview.interviewee.employee.mapper.EmployeeIntervieweeMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeIntervieweeServiceImpl implements EmployeeIntervieweeService {

    private final EmployeeIntervieweeRepository intervieweeRepository;
    private final EmployeeIntervieweeMapperService mapperService;
    private final InterviewService interviewService;

    @Override
    public EmployeeInterviewee create(Long interviewId, EmployeeIntervieweeRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewee = mapperService.toEntity(dto);
        interview.addInterviewee(interviewee);
        interviewService.save(interview);
        return interviewee;
    }

    @Override
    public List<EmployeeInterviewee> getAllByInterviewId(Long interviewerId) {
        return intervieweeRepository.findAllByInterviewId(interviewerId);
    }

    @Override
    public EmployeeInterviewee getById(Long interviewId, Long id) {
        return intervieweeRepository.findByInterviewIdAndId(interviewId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }



    @Override
    public EmployeeInterviewee update(Long interviewId, Long id, EmployeeIntervieweeRequest dto) {
        var interview = interviewService.getById(interviewId);
        var interviewee = (EmployeeInterviewee) interview.getInterviewees()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        interviewee = intervieweeRepository.save(mapperService.toEntity(interviewee,dto));
        interviewService.save(interview);
        return interviewee;
    }

    @Override
    public void delete(Long interviewId, Long id) {
        var interview = interviewService.getById(interviewId);
        var interviewee = (EmployeeInterviewee) interview.getInterviewees()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        interview.removeInterviewee(interviewee);
        interviewService.save(interview);
    }
    @Override
    public IntervieweeResponse toDTO(Interviewee interviewee) {
        return mapperService.toDTO(interviewee);
    }

    @Override
    public IntervieweeCompactResponse toCompactDTO(Interviewee interviewee) {
        return mapperService.toCompactDTO((EmployeeInterviewee) interviewee);
    }

}
