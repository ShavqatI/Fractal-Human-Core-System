package com.fractal.domain.training_management.training.participation.participant;

import com.fractal.domain.training_management.training.TrainingService;
import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationRequest;
import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationResponse;
import com.fractal.domain.training_management.training.participation.participant.mapper.TrainingParticipationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class TrainingParticipationServiceImpl implements TrainingParticipationService {

    private final TrainingParticipationRepository trainingParticipationRepository;
    private final TrainingParticipationMapperService mapperService;
    private final TrainingService trainingService;

    @Override
    @Transactional
    public TrainingParticipation create(Long trainingId, TrainingParticipationRequest dto) {
        var training = trainingService.getById(trainingId);
        var trainingParticipation = mapperService.toEntity(dto);
        training.addTrainingParticipation(trainingParticipation);
        trainingService.save(training);
       return trainingParticipation;
    }

    @Override
    public List<TrainingParticipation> getAllByTrainingId(Long trainingId) {
        return trainingParticipationRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public TrainingParticipation getById(Long trainingId, Long id) {
        return trainingParticipationRepository.findByTrainingIdAndId(trainingId,id).orElseThrow(()-> new ResourceNotFoundException("Question  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public TrainingParticipation update(Long trainingId, Long id, TrainingParticipationRequest dto) {
        var training = trainingService.getById(trainingId);
        var trainingParticipation = training.getParticipations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Question  with id: " + id + " not found"));
        trainingParticipation = mapperService.toEntity(trainingParticipation,dto);
        trainingParticipationRepository.save(trainingParticipation);
        trainingService.save(training);
       return trainingParticipation;
    }

    @Override
    @Transactional
    public void delete(Long trainingId, Long id) {
        var training = trainingService.getById(trainingId);
        var trainingParticipation = training.getParticipations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Question  with id: " + id + " not found"));
        training.removeTrainingParticipation(trainingParticipation);
        trainingService.save(training);
    }

    @Override
    public TrainingParticipationResponse toDTO(TrainingParticipation trainingParticipation) {
        return mapperService.toDTO(trainingParticipation);
    }


}
