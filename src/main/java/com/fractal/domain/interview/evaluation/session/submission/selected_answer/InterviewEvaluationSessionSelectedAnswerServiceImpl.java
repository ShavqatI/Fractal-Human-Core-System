package com.fractal.domain.interview.evaluation.session.submission.selected_answer;

import com.fractal.domain.interview.evaluation.session.submission.InterviewEvaluationSessionAnswerSubmissionService;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerCompactResponse;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerRequest;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.dto.InterviewEvaluationSessionSelectedAnswerResponse;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.mapper.InterviewEvaluationSessionSelectedAnswerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSessionSelectedAnswerServiceImpl implements InterviewEvaluationSessionSelectedAnswerService {

    private final InterviewEvaluationSessionSelectedAnswerRepository answerRepository;
    private final InterviewEvaluationSessionSelectedAnswerMapperService mapperService;
    private final InterviewEvaluationSessionAnswerSubmissionService answerSubmissionService;


    @Override
    @Transactional
    public InterviewEvaluationSessionSelectedAnswer create(Long answerSubmissionId, InterviewEvaluationSessionSelectedAnswerRequest dto) {
        var answerSubmission = answerSubmissionService.getById(answerSubmissionId);
        var selectedAnswer = mapperService.toEntity(dto);
        answerSubmission.addAnswer(selectedAnswer);
        answerSubmissionService.save(answerSubmission);
       return selectedAnswer;
    }

    @Override
    public List<InterviewEvaluationSessionSelectedAnswer> getAllByInterviewEvaluationSessionAnswerSubmissionId(Long answerSubmissionId) {
        return answerRepository.findAllByInterviewEvaluationSessionAnswerSubmissionId(answerSubmissionId);
    }

    @Override
    public InterviewEvaluationSessionSelectedAnswer getById(Long answerSubmissionId, Long id) {
        return answerRepository.findByInterviewEvaluationSessionAnswerSubmissionIdAndId(answerSubmissionId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session Selected Answer with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InterviewEvaluationSessionSelectedAnswer update(Long answerSubmissionId, Long id, InterviewEvaluationSessionSelectedAnswerRequest dto) {
        var answerSubmission = answerSubmissionService.getById(answerSubmissionId);
        var selectedAnswer = answerSubmission.getSelectedAnswers()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session Selected Answer with id: " + id + " not found"));
        selectedAnswer = answerRepository.save(mapperService.toEntity(selectedAnswer,dto));
        answerSubmissionService.save(answerSubmission);
        return selectedAnswer;
    }

    @Override
    @Transactional
    public void delete(Long answerSubmissionId, Long id) {
        var answerSubmission = answerSubmissionService.getById(answerSubmissionId);
        var selectedAnswer = answerSubmission.getSelectedAnswers()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        answerSubmission.removeAnswer(selectedAnswer);
        answerSubmissionService.save(answerSubmission);
    }

    @Override
    public InterviewEvaluationSessionSelectedAnswerResponse toDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer) {
        return mapperService.toDTO(selectedAnswer);
    }

    @Override
    public InterviewEvaluationSessionSelectedAnswerCompactResponse toCompactDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer) {
        return mapperService.toCompactDTO(selectedAnswer);
    }

}
