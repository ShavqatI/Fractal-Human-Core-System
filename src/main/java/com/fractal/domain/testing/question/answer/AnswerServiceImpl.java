package com.fractal.domain.testing.question.answer;

import com.fractal.domain.testing.question.QuestionService;
import com.fractal.domain.testing.question.answer.dto.AnswerRequest;
import com.fractal.domain.testing.question.answer.dto.AnswerResponse;
import com.fractal.domain.testing.question.answer.mapper.AnswerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapperService mapperService;
    private final QuestionService questionService;

    @Override
    @Transactional
    public Answer create(Long questionId, AnswerRequest dto) {
        var question = questionService.getById(questionId);
        var answer = mapperService.toEntity(dto);
        question.addAnswer(answer);
        questionService.save(question);
        return answer;
    }

    @Override
    public List<Answer> getAllByQuestionId(Long questionId) {
        return answerRepository.findAllByQuestionId(questionId);
    }

    @Override
    public Answer getById(Long questionId, Long id) {
        return answerRepository.findByQuestionIdAndId(questionId, id).orElseThrow(() -> new ResourceNotFoundException("Answer  with id: " + id + " not found"));
    }

    @Override
    public Answer getById(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Answer update(Long questionId, Long id, AnswerRequest dto) {
        var question = questionService.getById(questionId);
        var answer = question.getAnswers()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Answer  with id: " + id + " not found"));
        answer = mapperService.toEntity(answer, dto);
        answerRepository.save(answer);
        questionService.save(question);
        return answer;
    }

    @Override
    @Transactional
    public void delete(Long questionId, Long id) {
        var question = questionService.getById(questionId);
        var answer = question.getAnswers()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Answer  with id: " + id + " not found"));
        question.removeAnswer(answer);
        questionService.save(question);
    }

    @Override
    public AnswerResponse toDTO(Answer answer) {
        return mapperService.toDTO(answer);
    }
}
