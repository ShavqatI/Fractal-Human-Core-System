/*
package com.fractal.domain.interview.template.section.question.answer;

import com.fractal.domain.interview.evaluation.section.question.answer.mapper.InterviewEvaluationAnswerMapperService;
import com.fractal.domain.interview.template.section.question.InterviewTemplateQuestionService;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerRequest;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerResponse;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewTemplateAnswerServiceImpl implements InterviewTemplateAnswerService {

    private final InterviewTemplateAnswerRepository answerRepository;
    private final InterviewEvaluationAnswerMapperService mapperService;
    private final InterviewTemplateQuestionService questionService;


    @Override
    @Transactional
    public InterviewTemplateAnswer create(Long questionId, InterviewTemplateAnswerRequest dto) {
        var question = questionService.getById(questionId);
        var answer = mapperService.toEntity(dto);
        question.addAnswer(answer);
        questionService.save(question);
       return answer;
    }

    @Override
    public List<InterviewTemplateAnswer> getAllByQuestionId(Long questionId) {
        return answerRepository.findAllByInterviewTemplateQuestionId(questionId);
    }

    @Override
    public InterviewTemplateAnswer getById(Long questionId, Long id) {
        return answerRepository.findByInterviewTemplateQuestionIdAndId(questionId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Answer with id: " + id + " not found"));
    }



    @Override
    @Transactional
    public InterviewTemplateAnswer update(Long questionId, Long id, InterviewTemplateAnswerRequest dto) {
        var question = questionService.getById(questionId);
        var answer = question.getAnswers()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Answer with id: " + id + " not found"));
        answer = answerRepository.save(mapperService.toEntity(answer,dto));
        questionService.save(question);
        return answer;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var question = questionService.getById(employeeId);
        var answer = question.getAnswers()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        question.removeAnswer(answer);
        questionService.save(question);
    }

    @Override
    public InterviewTemplateAnswerResponse toDTO(InterviewTemplateAnswer answer) {
        return mapperService.toDTO(answer);
    }
}
*/
