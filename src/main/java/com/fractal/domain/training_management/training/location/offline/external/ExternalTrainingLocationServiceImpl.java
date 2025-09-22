package com.fractal.domain.training_management.training.location.offline.external;

import com.fractal.domain.training_management.training.TrainingService;
import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationResponse;
import com.fractal.domain.training_management.training.location.offline.external.mapper.ExternalTrainingLocationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ExternalTrainingLocationServiceImpl implements ExternalTrainingLocationService {

    private final ExternalTrainingLocationRepository locationRepository;
    private final ExternalTrainingLocationMapperService mapperService;
    private final TrainingService trainingService;

    @Override
    public ExternalTrainingLocation create(Long trainingId, ExternalTrainingLocationRequest dto) {
        var training = trainingService.getById(trainingId);
        var location = mapperService.toEntity(dto);
        training.addLocation(location);
        trainingService.save(training);
        return location;
    }

    @Override
    public List<ExternalTrainingLocation> getAllByTrainingId(Long trainingId) {
        return locationRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public ExternalTrainingLocation getById(Long trainingId, Long id) {
        return locationRepository.findByTrainingIdAndId(trainingId,id).orElseThrow(()->new ResourceNotFoundException("External Training Location with id: " + id + " not found"));
    }

    @Override
    public ExternalTrainingLocation getById(Long id) {
        return locationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("External Training Location with id: " + id + " not found"));
    }

    @Override
    public ExternalTrainingLocationResponse toDTO(ExternalTrainingLocation location) {
        return mapperService.toDTO(location);
    }

    @Override
    public ExternalTrainingLocation update(Long trainingId, Long id, ExternalTrainingLocationRequest dto) {
        var training = trainingService.getById(trainingId);
        var location = (ExternalTrainingLocation) training.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("External Training Location  with id: " + id + " not found"));
        location = mapperService.toEntity( location,dto);
        locationRepository.save(location);
        trainingService.save(training);
        return location;
    }

    @Override
    public void delete(Long trainingId, Long id) {
        var training = trainingService.getById(trainingId);
        var location = (ExternalTrainingLocation) training.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("External Training Location  with id: " + id + " not found"));
        training.removeLocation(location);
        trainingService.save(training);
    }

    @Override
    public ExternalTrainingLocation save(ExternalTrainingLocation location) {
        try {
            return locationRepository.save(location);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
