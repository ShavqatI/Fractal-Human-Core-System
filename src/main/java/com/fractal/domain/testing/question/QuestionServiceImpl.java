package com.fractal.domain.testing.question;

import com.fractal.domain.testing.question.dto.QuestionCompactResponse;
import com.fractal.domain.testing.question.dto.QuestionRequest;
import com.fractal.domain.testing.question.dto.QuestionResponse;
import com.fractal.domain.testing.question.mapper.QuestionMapperService;
import com.fractal.domain.testing.test.TestService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapperService mapperService;
    private final TestService testService;

    @Override
    @Transactional
    public Question create(Long testId, QuestionRequest dto) {
        var test = testService.getById(testId);
        var question = mapperService.toEntity(dto);
        test.addQuestion(question);
        testService.save(test);
        return question;
    }

    @Override
    public List<Question> getAllByTestId(Long testId) {
        return questionRepository.findAllByTestId(testId);
    }

    @Override
    public Question getById(Long testId, Long id) {
        return questionRepository.findByTestIdAndId(testId, id).orElseThrow(() -> new ResourceNotFoundException("Question  with id: " + id + " not found"));
    }

    @Override
    public Question getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Question update(Long testId, Long id, QuestionRequest dto) {
        var test = testService.getById(testId);
        var question = test.getQuestions()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Question  with id: " + id + " not found"));
        question = mapperService.toEntity(question, dto);
        questionRepository.save(question);
        testService.save(test);
        return question;
    }

    @Override
    @Transactional
    public void delete(Long testId, Long id) {
        var test = testService.getById(testId);
        var question = test.getQuestions()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Question  with id: " + id + " not found"));
        test.removeQuestion(question);
        testService.save(test);
    }

    @Override
    public QuestionResponse toDTO(Question question) {
        return mapperService.toDTO(question);
    }

    @Override
    public QuestionCompactResponse toCompactDTO(Question question) {
        return mapperService.toCompactDTO(question);
    }


    @Override
    public Question save(Question question) {
        try {
            return questionRepository.save(question);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question with id: " + id + " not found"));
    }
}
