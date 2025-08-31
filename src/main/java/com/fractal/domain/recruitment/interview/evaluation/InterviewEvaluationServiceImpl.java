package com.fractal.domain.recruitment.interview.evaluation;

import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;
import com.fractal.domain.recruitment.interview.evaluation.mapper.InterviewEvaluationMapperService;
import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationServiceImpl implements InterviewEvaluationService {

    private final InterviewEvaluationRepository interviewEvaluationRepository;
    private final InterviewEvaluationMapperService mapperService;


    @Override
    public InterviewEvaluation create(InterviewEvaluationRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InterviewEvaluation> getAll() {
        return interviewEvaluationRepository.findAll();
    }



    @Override
    public InterviewEvaluation getById(Long id) {
     return findById(id);
    }

    @Override
    public InterviewEvaluation update(Long id, InterviewEvaluationRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id),dto));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       interviewEvaluationRepository.delete(findById(id));
    }

    @Override
    public InterviewEvaluation save(InterviewEvaluation interviewEvaluation) {
        try {
            return interviewEvaluationRepository.save(interviewEvaluation);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public InterviewEvaluationResponse toDTO(InterviewEvaluation interviewEvaluation) {
        return mapperService.toDTO(interviewEvaluation);
    }

    private InterviewEvaluation findById(Long id) {
        return interviewEvaluationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation with id: " + id + " not found"));

    }
}
