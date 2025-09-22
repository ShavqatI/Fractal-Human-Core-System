package com.fractal.domain.training_management.training.location.offline.internal;

import com.fractal.domain.training_management.training.TrainingService;
import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationResponse;
import com.fractal.domain.training_management.training.location.offline.internal.mapper.InternalTrainingLocationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InternalTrainingLocationServiceImpl implements InternalTrainingLocationService {

    private final InternalTrainingLocationRepository locationRepository;
    private final InternalTrainingLocationMapperService mapperService;
    private final TrainingService trainingService;

    @Override
    public InternalTrainingLocation create(Long trainingId, InternalTrainingLocationRequest dto) {
        var training = trainingService.getById(trainingId);
        var location = mapperService.toEntity(dto);
        training.addLocation(location);
        trainingService.save(training);
        return location;
    }

    @Override
    public List<InternalTrainingLocation> getAllByTrainingId(Long trainingId) {
        return locationRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public InternalTrainingLocation getById(Long trainingId, Long id) {
        return locationRepository.findByTrainingIdAndId(trainingId,id).orElseThrow(()->new ResourceNotFoundException("External Training Location with id: " + id + " not found"));
    }

    @Override
    public InternalTrainingLocationResponse toDTO(InternalTrainingLocation location) {
        return mapperService.toDTO(location);
    }

    @Override
    public InternalTrainingLocation update(Long trainingId, Long id, InternalTrainingLocationRequest dto) {
        var training = trainingService.getById(trainingId);
        var location = (InternalTrainingLocation) training.getLocations()
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
        var location = (InternalTrainingLocation) training.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("External Training Location  with id: " + id + " not found"));
        training.removeLocation(location);
        trainingService.save(training);
    }
}
