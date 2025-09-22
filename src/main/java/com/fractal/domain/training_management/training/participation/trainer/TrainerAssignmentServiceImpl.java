package com.fractal.domain.training_management.training.participation.trainer;

import com.fractal.domain.training_management.training.TrainingService;
import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentRequest;
import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentResponse;
import com.fractal.domain.training_management.training.participation.trainer.mapper.TrainerAssignmentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class TrainerAssignmentServiceImpl implements TrainerAssignmentService {

    private final TrainerAssignmentRepository trainerAssignmentRepository;
    private final TrainerAssignmentMapperService mapperService;
    private final TrainingService trainingService;

    @Override
    @Transactional
    public TrainerAssignment create(Long trainingId, TrainerAssignmentRequest dto) {
        var training = trainingService.getById(trainingId);
        var trainerAssignment = mapperService.toEntity(dto);
        training.addTrainerAssignment(trainerAssignment);
        trainingService.save(training);
       return trainerAssignment;
    }

    @Override
    public List<TrainerAssignment> getAllByTrainingId(Long trainingId) {
        return trainerAssignmentRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public TrainerAssignment getById(Long trainingId, Long id) {
        return trainerAssignmentRepository.findByTrainingIdAndId(trainingId,id).orElseThrow(()-> new ResourceNotFoundException("Question  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public TrainerAssignment update(Long trainingId, Long id, TrainerAssignmentRequest dto) {
        var training = trainingService.getById(trainingId);
        var trainerAssignment = training.getTrainerAssignments()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Question  with id: " + id + " not found"));
        trainerAssignment = mapperService.toEntity(trainerAssignment,dto);
        trainerAssignmentRepository.save(trainerAssignment);
        trainingService.save(training);
       return trainerAssignment;
    }

    @Override
    @Transactional
    public void delete(Long trainingId, Long id) {
        var training = trainingService.getById(trainingId);
        var trainerAssignment = training.getTrainerAssignments()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Question  with id: " + id + " not found"));
        training.removeTrainerAssignment(trainerAssignment);
        trainingService.save(training);
    }

    @Override
    public TrainerAssignmentResponse toDTO(TrainerAssignment trainerAssignment) {
        return mapperService.toDTO(trainerAssignment);
    }



}
