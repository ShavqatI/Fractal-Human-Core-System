package com.fractal.domain.training_management.training.participation.trainer;


import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentRequest;
import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentResponse;

import java.util.List;
public interface TrainerAssignmentService {

    TrainerAssignment create(Long trainingId, TrainerAssignmentRequest dto);
    List<TrainerAssignment> getAllByTrainingId(Long trainingId);
    TrainerAssignment getById(Long trainingId , Long id);
    TrainerAssignmentResponse toDTO(TrainerAssignment trainerAssignment);
    TrainerAssignment update(Long trainingId, Long id, TrainerAssignmentRequest dto);
    void delete(Long trainingId,Long id);


}
