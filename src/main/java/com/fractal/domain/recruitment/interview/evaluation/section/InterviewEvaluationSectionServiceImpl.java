package com.fractal.domain.recruitment.interview.evaluation.section;

import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluationService;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.mapper.InterviewEvaluationSectionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSectionServiceImpl implements InterviewEvaluationSectionService {

    private final InterviewEvaluationSectionRepository sectionRepository;
    private final InterviewEvaluationSectionMapperService mapperService;
    private final InterviewEvaluationService interviewEvaluationService;


    @Override
    @Transactional
    public InterviewEvaluationSection create(Long evaluationId, InterviewEvaluationSectionRequest dto) {
        var evaluation = interviewEvaluationService.getById(evaluationId);
        var section = mapperService.toEntity(dto);
        evaluation.addSection(section);
        interviewEvaluationService.save(evaluation);
       return section;
    }

    @Override
    public List<InterviewEvaluationSection> getAllByInterviewEvaluationId(Long evaluationId) {
        return sectionRepository.findAllByEvaluationId(evaluationId);
    }

    @Override
    public InterviewEvaluationSection getById(Long evaluationId, Long id) {
        return sectionRepository.findByEvaluationIdAndId(evaluationId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Section with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InterviewEvaluationSection update(Long evaluationId, Long id, InterviewEvaluationSectionRequest dto) {
        var evaluation = interviewEvaluationService.getById(evaluationId);
        var section = evaluation.getSections()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        section = sectionRepository.save(mapperService.toEntity(section,dto));
        interviewEvaluationService.save(evaluation);
        return section;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var evaluation = interviewEvaluationService.getById(employeeId);
        var section = evaluation.getSections()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        evaluation.removeSection(section);
        interviewEvaluationService.save(evaluation);
    }

    @Override
    public InterviewEvaluationSectionResponse toDTO(InterviewEvaluationSection section) {
        return mapperService.toDTO(section);
    }

    /*@Override
    public InterviewEvaluationQuestionCompactResponse toCompactDTO(InterviewEvaluationQuestion question) {
        return mapperService.toCompactDTO(question);
    }*/

    @Override
    public InterviewEvaluationSection getById(Long id) {
        return sectionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Section with id: " + id + " not found"));
    }

    @Override
    public InterviewEvaluationSection save(InterviewEvaluationSection section) {
        try {
            return sectionRepository.save(section);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
