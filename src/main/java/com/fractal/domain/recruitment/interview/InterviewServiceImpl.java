package com.fractal.domain.recruitment.interview;

import com.fractal.domain.recruitment.interview.dto.InterviewRequest;
import com.fractal.domain.recruitment.interview.dto.InterviewResponse;
import com.fractal.domain.recruitment.interview.mapper.InterviewMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final InterviewMapperService mapperService;


    @Override
    public Interview create(InterviewRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Interview> getAll() {
        return interviewRepository.findAll();
    }



    @Override
    public Interview getById(Long id) {
     return findById(id);
    }

    @Override
    public Interview update(Long id, InterviewRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id),dto));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       interviewRepository.delete(findById(id));
    }

    @Override
    public Interview save(Interview interview) {
        try {
            return interviewRepository.save(interview);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public InterviewResponse toDTO(Interview interview) {
        return mapperService.toDTO(interview);
    }

    private Interview findById(Long id) {
        return interviewRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview with id: " + id + " not found"));

    }
}
