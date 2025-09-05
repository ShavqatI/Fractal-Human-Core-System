package com.fractal.domain.recruitment.interview;

import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.recruitment.interview.evaluation.dto.InterviewEvaluationResponse;
import com.fractal.domain.recruitment.interview.evaluation.mapper.InterviewEvaluationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final InterviewEvaluationMapperService mapperService;


    @Override
    public InterviewEvaluation create(InterviewEvaluationRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InterviewEvaluation> getAll() {
        return interviewRepository.findAll();
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
       interviewRepository.delete(findById(id));
    }

    @Override
    public InterviewEvaluation save(InterviewEvaluation interviewEvaluation) {
        try {
            return interviewRepository.save(interviewEvaluation);
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
        return interviewRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation with id: " + id + " not found"));

    }
}
