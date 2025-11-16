package com.fractal.domain.learning_develpment.learning.session.location.online;

import com.fractal.domain.learning_develpment.learning.session.LearningSessionService;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.online.mapper.OnlineLearningLocationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OnlineLearningLocationServiceImpl implements OnlineLearningLocationService {

    private final OnlineLearningLocationRepository locationRepository;
    private final OnlineLearningLocationMapperService mapperService;
    private final LearningSessionService learningSessionService;

    @Override
    public OnlineLearningLocation create(Long sessionId, OnlineLearningLocationRequest dto) {
        var session = learningSessionService.getById(sessionId);
        var location = mapperService.toEntity(dto);
        session.addLocation(location);
        learningSessionService.save(session);
        return location;
    }

    @Override
    public List<OnlineLearningLocation> getAllByLearningSessionId(Long sessionId) {
        return locationRepository.findAllByLearningSessionId(sessionId);
    }

    @Override
    public OnlineLearningLocation getById(Long sessionId, Long id) {
        return locationRepository.findByLearningSessionIdAndId(sessionId, id).orElseThrow(() -> new ResourceNotFoundException("External Training Location with id: " + id + " not found"));
    }

    @Override
    public OnlineLearningLocationResponse toDTO(OnlineLearningLocation location) {
        return mapperService.toDTO(location);
    }

    @Override
    public OnlineLearningLocation update(Long sessionId, Long id, OnlineLearningLocationRequest dto) {
        var session = learningSessionService.getById(sessionId);
        var location = (OnlineLearningLocation) session.getLocations()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("External Training Location  with id: " + id + " not found"));
        location = mapperService.toEntity(location, dto);
        locationRepository.save(location);
        learningSessionService.save(session);
        return location;
    }

    @Override
    public void delete(Long sessionId, Long id) {
        var session = learningSessionService.getById(sessionId);
        var location = (OnlineLearningLocation) session.getLocations()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("External Training Location  with id: " + id + " not found"));
        session.removeLocation(location);
        learningSessionService.save(session);
    }
}
