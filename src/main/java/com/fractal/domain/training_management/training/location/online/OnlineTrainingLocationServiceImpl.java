package com.fractal.domain.training_management.training.location.online;

import com.fractal.domain.training_management.training.TrainingService;
import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationResponse;
import com.fractal.domain.training_management.training.location.online.mapper.OnlineTrainingLocationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OnlineTrainingLocationServiceImpl implements OnlineTrainingLocationService {

    private final OnlineTrainingLocationRepository locationRepository;
    private final OnlineTrainingLocationMapperService mapperService;
    private final TrainingService trainingService;

    @Override
    public OnlineTrainingLocation create(Long trainingId, OnlineTrainingLocationRequest dto) {
        var training = trainingService.getById(trainingId);
        var location = mapperService.toEntity(dto);
        training.addLocation(location);
        trainingService.save(training);
        return location;
    }

    @Override
    public List<OnlineTrainingLocation> getAllByTrainingId(Long trainingId) {
        return locationRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public OnlineTrainingLocation getById(Long trainingId, Long id) {
        return locationRepository.findByTrainingIdAndId(trainingId,id).orElseThrow(()->new ResourceNotFoundException("External Training Location with id: " + id + " not found"));
    }

    @Override
    public OnlineTrainingLocationResponse toDTO(OnlineTrainingLocation location) {
        return mapperService.toDTO(location);
    }

    @Override
    public OnlineTrainingLocation update(Long trainingId, Long id, OnlineTrainingLocationRequest dto) {
        var training = trainingService.getById(trainingId);
        var location = (OnlineTrainingLocation) training.getLocations()
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
        var location = (OnlineTrainingLocation) training.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("External Training Location  with id: " + id + " not found"));
        training.removeLocation(location);
        trainingService.save(training);
    }
}
