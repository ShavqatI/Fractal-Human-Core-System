package com.fractal.domain.learning_develpment.learning.session.location.offline;

import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.offline.mapper.OfflineLearningLocationMapperService;
import com.fractal.domain.learning_develpment.learning.session.LearningSessionService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OfflineLearningLocationServiceImpl implements OfflineLearningLocationService {

    private final OfflineLearningLocationRepository locationRepository;
    private final OfflineLearningLocationMapperService mapperService;
    private final LearningSessionService learningSessionService;

    @Override
    public OfflineLearningLocation create(Long sessionId, OfflineLearningLocationRequest dto) {
        var session = learningSessionService.getById(sessionId);
        var location = mapperService.toEntity(dto);
        session.addLocation(location);
        learningSessionService.save(session);
        return location;
    }

    @Override
    public List<OfflineLearningLocation> getAllByLearningSessionId(Long sessionId) {
        return locationRepository.findAllByLearningSessionId(sessionId);
    }

    @Override
    public OfflineLearningLocation getById(Long sessionId, Long id) {
        return locationRepository.findByLearningSessionIdAndId(sessionId,id).orElseThrow(()->new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public OfflineLearningLocation getById(Long id) {
        return locationRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public OfflineLearningLocationResponse toDTO(OfflineLearningLocation location) {
        return mapperService.toDTO(location);
    }

    @Override
    public OfflineLearningLocation update(Long sessionId, Long id, OfflineLearningLocationRequest dto) {
        var session = learningSessionService.getById(sessionId);
        var location = (OfflineLearningLocation) session.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        location = mapperService.toEntity( location,dto);
        locationRepository.save(location);
        learningSessionService.save(session);
        return location;
    }

    @Override
    public void delete(Long sessionId, Long id) {
        var session = learningSessionService.getById(sessionId);
        var location = (OfflineLearningLocation) session.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        session.removeLocation(location);
        learningSessionService.save(session);
    }

    @Override
    public OfflineLearningLocation save(OfflineLearningLocation location) {
        try {
            return locationRepository.save(location);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
