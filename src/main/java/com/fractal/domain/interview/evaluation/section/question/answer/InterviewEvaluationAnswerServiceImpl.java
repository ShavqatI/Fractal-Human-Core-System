package com.fractal.domain.interview.evaluation.section.question.answer;

import com.fractal.domain.interview.evaluation.section.question.InterviewEvaluationQuestionService;
import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;
import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;
import com.fractal.domain.interview.evaluation.section.question.answer.mapper.InterviewEvaluationAnswerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationAnswerServiceImpl implements InterviewEvaluationAnswerService {

    private final InterviewEvaluationAnswerRepository answerRepository;
    private final InterviewEvaluationAnswerMapperService mapperService;
    private final InterviewEvaluationQuestionService questionService;


    @Override
    @Transactional
    public InterviewEvaluationAnswer create(Long questionId, InterviewEvaluationAnswerRequest dto) {
        var question = questionService.getById(questionId);
        var answer = mapperService.toEntity(dto);
        question.addAnswer(answer);
        questionService.save(question);
       return answer;
    }

    @Override
    public List<InterviewEvaluationAnswer> getAllByQuestionId(Long questionId) {
        return answerRepository.findAllByInterviewEvaluationQuestionId(questionId);
    }

    @Override
    public InterviewEvaluationAnswer getById(Long questionId, Long id) {
        return answerRepository.findByInterviewEvaluationQuestionIdAndId(questionId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Answer with id: " + id + " not found"));
    }



    @Override
    @Transactional
    public InterviewEvaluationAnswer update(Long questionId, Long id, InterviewEvaluationAnswerRequest dto) {
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
    public InterviewEvaluationAnswerResponse toDTO(InterviewEvaluationAnswer answer) {
        return mapperService.toDTO(answer);
    }
}
