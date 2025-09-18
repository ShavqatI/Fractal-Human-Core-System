package com.fractal.domain.testing.test.session.answer;

import com.fractal.domain.testing.test.session.TestSessionService;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionRequest;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionResponse;
import com.fractal.domain.testing.test.session.answer.mapper.AnswerSubmissionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class AnswerSubmissionServiceImpl implements AnswerSubmissionService {

    private final AnswerSubmissionRepository submissionRepository;
    private final AnswerSubmissionMapperService mapperService;
    private final TestSessionService testService;

    @Override
    @Transactional
    public AnswerSubmission create(Long testSessionId, AnswerSubmissionRequest dto) {
        var testSession = testService.getById(testSessionId);
        var submission = mapperService.toEntity(dto);
        testSession.addAnswerSubmission(submission);
        testService.save(testSession);
       return submission;
    }

    @Override
    public List<AnswerSubmission> getAllBySessionId(Long testSessionId) {
        return submissionRepository.findAllByTestSessionId(testSessionId);
    }

    @Override
    public AnswerSubmission getById(Long testSessionId, Long id) {
        return submissionRepository.findByTestSessionIdAndId(testSessionId,id).orElseThrow(()-> new ResourceNotFoundException("Answer Submission  with id: " + id + " not found"));
    }

    @Override
    public AnswerSubmission getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public AnswerSubmission update(Long testSessionId, Long id, AnswerSubmissionRequest dto) {
        var testSession = testService.getById(testSessionId);
        var submission = testSession.getSubmissions()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Answer Submission  with id: " + id + " not found"));
        submission = mapperService.toEntity(submission,dto);
        submissionRepository.save(submission);
        testService.save(testSession);
       return submission;
    }

    @Override
    @Transactional
    public void delete(Long testId, Long id) {
        var testSession = testService.getById(testId);
        var submission = testSession.getSubmissions()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Answer Submission  with id: " + id + " not found"));
        testSession.removeAnswerSubmission(submission);
        testService.save(testSession);
    }

    @Override
    public AnswerSubmissionResponse toDTO(AnswerSubmission submission) {
        return mapperService.toDTO(submission);
    }
    @Override
    public AnswerSubmission save(AnswerSubmission submission) {
        try {
            return submissionRepository.save(submission);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
    private AnswerSubmission findById(Long id) {
        return submissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Answer Submission with id: " + id + " not found"));
    }
}
