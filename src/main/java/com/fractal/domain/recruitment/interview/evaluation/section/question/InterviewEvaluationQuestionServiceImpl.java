package com.fractal.domain.recruitment.interview.evaluation.section.question;

import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSectionService;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.mapper.InterviewEvaluationQuestionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationQuestionServiceImpl implements InterviewEvaluationQuestionService {

    private final InterviewEvaluationQuestionRepository questionRepository;
    private final InterviewEvaluationQuestionMapperService mapperService;
    private final InterviewEvaluationSectionService sectionService;


    @Override
    @Transactional
    public InterviewEvaluationQuestion create(Long sectionId, InterviewEvaluationQuestionRequest dto) {
        var section = sectionService.getById(sectionId);
        var question = mapperService.toEntity(dto);
        section.addQuestion(question);
        sectionService.save(section);
       return question;
    }

    @Override
    public List<InterviewEvaluationQuestion> getAllBySectionId(Long sectionId) {
        return questionRepository.findAllByInterviewEvaluationSectionId(sectionId);
    }

    @Override
    public InterviewEvaluationQuestion getById(Long employeeId, Long id) {
        return questionRepository.findByInterviewEvaluationSectionIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Question with id: " + id + " not found"));
    }

    @Override
    public InterviewEvaluationQuestion getById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Question with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InterviewEvaluationQuestion update(Long sectionId, Long id, InterviewEvaluationQuestionRequest dto) {
        var section = sectionService.getById(sectionId);
        var question = section.getQuestions()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Question with id: " + id + " not found"));
        question = questionRepository.save(mapperService.toEntity(question,dto));
        sectionService.save(section);
        return question;
    }

    @Override
    @Transactional
    public void delete(Long sectionId, Long id) {
        var section = sectionService.getById(sectionId);
        var question = section.getQuestions()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Question with id: " + id + " not found"));
        section.removeQuestion(question);
        sectionService.save(section);
    }


    @Override
    public InterviewEvaluationQuestionResponse toDTO(InterviewEvaluationQuestion question) {
        return mapperService.toDTO(question);
    }

    @Override
    public InterviewEvaluationQuestionCompactResponse toCompactDTO(InterviewEvaluationQuestion question) {
        return mapperService.toCompactDTO(question);
    }

    @Override
    public InterviewEvaluationQuestion save(InterviewEvaluationQuestion question) {
        try {
            return questionRepository.save(question);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
