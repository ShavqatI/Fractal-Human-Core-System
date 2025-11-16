package com.fractal.domain.learning_develpment.learning.session;

import com.fractal.domain.learning_develpment.learning.LearningService;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionCompactResponse;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionRequest;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionResponse;
import com.fractal.domain.learning_develpment.learning.session.mapper.LearningSessionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class LearningSessionServiceImpl implements LearningSessionService {

    private final LearningSessionRepository learningSessionRepository;
    private final LearningSessionMapperService mapperService;
    private final LearningService learningService;

    @Override
    @Transactional
    public LearningSession create(Long learningId, LearningSessionRequest dto) {
        var learning = learningService.getById(learningId);
        var session = mapperService.toEntity(dto);
        learning.addSession(session);
        learningService.save(learning);
        return session;
    }

    @Override
    public List<LearningSession> getAllByLearningId(Long learningId) {
        return learningSessionRepository.findAllByLearningId(learningId);
    }

    @Override
    public LearningSession getById(Long learningId, Long id) {
        return learningSessionRepository.findByLearningIdAndId(learningId, id).orElseThrow(() -> new ResourceNotFoundException("Question  with id: " + id + " not found"));
    }

    @Override
    public LearningSession getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public LearningSession update(Long testId, Long id, LearningSessionRequest dto) {
        var learning = learningService.getById(testId);
        var session = learning.getSessions()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        session = mapperService.toEntity(session, dto);
        learningSessionRepository.save(session);
        learningService.save(learning);
        return session;
    }

    @Override
    @Transactional
    public void delete(Long learningId, Long id) {
        var learning = learningService.getById(learningId);
        var question = learning.getSessions()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        learning.removeSession(question);
        learningService.save(learning);
    }

    @Override
    public LearningSessionResponse toDTO(LearningSession session) {
        return mapperService.toDTO(session);
    }

    @Override
    public LearningSessionCompactResponse toCompactDTO(LearningSession session) {
        return mapperService.toCompactDTO(session);
    }


    @Override
    public LearningSession save(LearningSession session) {
        try {
            return learningSessionRepository.save(session);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LearningSession findById(Long id) {
        return learningSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question with id: " + id + " not found"));
    }
}
