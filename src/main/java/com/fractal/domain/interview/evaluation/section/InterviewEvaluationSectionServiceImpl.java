package com.fractal.domain.interview.evaluation.section;

import com.fractal.domain.interview.evaluation.InterviewEvaluationService;
import com.fractal.domain.interview.evaluation.section.dto.InterviewEvaluationSectionCompactResponse;
import com.fractal.domain.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.interview.evaluation.section.mapper.InterviewEvaluationSectionMapperService;
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
        return sectionRepository.findAllByInterviewEvaluationId(evaluationId);
    }

    @Override
    public InterviewEvaluationSection getById(Long evaluationId, Long id) {
        return sectionRepository.findByInterviewEvaluationIdAndId(evaluationId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Section with id: " + id + " not found"));
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

    @Override
    public InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section) {
        return mapperService.toCompactDTO(section);
    }

    @Override
    public InterviewEvaluationSection addChild(Long id, InterviewEvaluationSectionRequest dto) {
        var section = getById(id);
        var child = mapperService.toEntity(dto);
        section.addChild(child);
        return save(section);
    }

    @Override
    public InterviewEvaluationSection updateChild(Long id, Long childId, InterviewEvaluationSectionRequest dto) {
        var section = getById(id);
        var child = section.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        try {
            child = mapperService.toEntity(child,dto);
            save(child);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
        return save(section);
    }

    @Override
    public InterviewEvaluationSection deleteChild(Long id, Long childId) {
        var section = getById(id);
        var child = section.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        section.removeChild(child);
        return section;
    }

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
