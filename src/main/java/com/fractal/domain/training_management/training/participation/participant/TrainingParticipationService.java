package com.fractal.domain.training_management.training.participation.participant;


import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationRequest;
import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationResponse;

import java.util.List;
public interface TrainingParticipationService {

    TrainingParticipation create(Long trainingId, TrainingParticipationRequest dto);
    List<TrainingParticipation> getAllByTrainingId(Long trainingId);
    TrainingParticipation getById(Long trainingId , Long id);
    TrainingParticipationResponse toDTO(TrainingParticipation trainingParticipation);
    TrainingParticipation update(Long trainingId, Long id, TrainingParticipationRequest dto);
    void delete(Long trainingId,Long id);


}
