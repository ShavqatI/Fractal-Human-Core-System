/*
package com.fractal.domain.interview.template;

import com.fractal.domain.interview.template.dto.InterviewTemplateRequest;
import com.fractal.domain.interview.template.dto.InterviewTemplateResponse;
import com.fractal.domain.interview.template.mapper.InterviewTemplateMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewTemplateServiceImpl implements InterviewTemplateService {

    private final InterviewTemplateRepository interviewTemplateRepository;
    private final InterviewTemplateMapperService mapperService;


    @Override
    public InterviewTemplate create(InterviewTemplateRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InterviewTemplate> getAll() {
        return interviewTemplateRepository.findAll();
    }



    @Override
    public InterviewTemplate getById(Long id) {
     return findById(id);
    }

    @Override
    public InterviewTemplate update(Long id, InterviewTemplateRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id),dto));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       interviewTemplateRepository.delete(findById(id));
    }

    @Override
    public InterviewTemplate save(InterviewTemplate interviewTemplate) {
        try {
            return interviewTemplateRepository.save(interviewTemplate);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public InterviewTemplateResponse toDTO(InterviewTemplate interviewTemplate) {
        return mapperService.toDTO(interviewTemplate);
    }

    private InterviewTemplate findById(Long id) {
        return interviewTemplateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation with id: " + id + " not found"));

    }
}
*/
