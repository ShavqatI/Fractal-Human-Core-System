/*
package com.fractal.domain.interview.template.section.question;

import com.fractal.domain.interview.template.section.InterviewTemplateSectionService;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionCompactResponse;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionRequest;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionResponse;
import com.fractal.domain.interview.template.section.question.mapper.InterviewTemplateQuestionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewTemplateQuestionServiceImpl implements InterviewTemplateQuestionService {

    private final InterviewTemplateQuestionRepository questionRepository;
    private final InterviewTemplateQuestionMapperService mapperService;
    private final InterviewTemplateSectionService sectionService;


    @Override
    @Transactional
    public InterviewTemplateQuestion create(Long sectionId, InterviewTemplateQuestionRequest dto) {
        var section = sectionService.getById(sectionId);
        var question = mapperService.toEntity(dto);
        section.addQuestion(question);
        sectionService.save(section);
       return question;
    }

    @Override
    public List<InterviewTemplateQuestion> getAllBySectionId(Long sectionId) {
        return questionRepository.findAllByInterviewTemplateSectionId(sectionId);
    }

    @Override
    public InterviewTemplateQuestion getById(Long employeeId, Long id) {
        return questionRepository.findByInterviewTemplateSectionIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Question with id: " + id + " not found"));
    }

    @Override
    public InterviewTemplateQuestion getById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Question with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InterviewTemplateQuestion update(Long sectionId, Long id, InterviewTemplateQuestionRequest dto) {
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
    public InterviewTemplateQuestionResponse toDTO(InterviewTemplateQuestion question) {
        return mapperService.toDTO(question);
    }

    @Override
    public InterviewTemplateQuestionCompactResponse toCompactDTO(InterviewTemplateQuestion question) {
        return mapperService.toCompactDTO(question);
    }

    @Override
    public InterviewTemplateQuestion save(InterviewTemplateQuestion question) {
        try {
            return questionRepository.save(question);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
*/
