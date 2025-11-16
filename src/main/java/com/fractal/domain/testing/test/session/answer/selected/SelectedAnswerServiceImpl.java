package com.fractal.domain.testing.test.session.answer.selected;

import com.fractal.domain.testing.test.session.answer.AnswerSubmissionService;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerRequest;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerResponse;
import com.fractal.domain.testing.test.session.answer.selected.mapper.SelectedAnswerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class SelectedAnswerServiceImpl implements SelectedAnswerService {

    private final SelectedAnswerRepository selectedAnswerRepository;
    private final SelectedAnswerMapperService mapperService;
    private final AnswerSubmissionService submissionService;

    @Override
    @Transactional
    public SelectedAnswer create(Long questionId, SelectedAnswerRequest dto) {
        var submission = submissionService.getById(questionId);
        var answer = mapperService.toEntity(dto);
        submission.addAnswer(answer);
        submissionService.save(submission);
        return answer;
    }

    @Override
    public List<SelectedAnswer> getAllByAnswerSubmissionId(Long questionId) {
        return selectedAnswerRepository.findAllByAnswerSubmissionId(questionId);
    }

    @Override
    public SelectedAnswer getById(Long questionId, Long id) {
        return selectedAnswerRepository.findByAnswerSubmissionIdAndId(questionId, id).orElseThrow(() -> new ResourceNotFoundException("Selected Answer  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public SelectedAnswer update(Long questionId, Long id, SelectedAnswerRequest dto) {
        var submission = submissionService.getById(questionId);
        var answer = submission.getSelectedAnswers()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Selected Answer  with id: " + id + " not found"));
        answer = mapperService.toEntity(answer, dto);
        selectedAnswerRepository.save(answer);
        submissionService.save(submission);
        return answer;
    }

    @Override
    @Transactional
    public void delete(Long questionId, Long id) {
        var submission = submissionService.getById(questionId);
        var answer = submission.getSelectedAnswers()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Selected Answer  with id: " + id + " not found"));
        submission.removeAnswer(answer);
        submissionService.save(submission);
    }

    @Override
    public SelectedAnswerResponse toDTO(SelectedAnswer selectedAnswer) {
        return mapperService.toDTO(selectedAnswer);
    }
}
