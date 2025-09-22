package com.fractal.domain.training_management.training.participation.participant.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.training_management.participant.ParticipantService;
import com.fractal.domain.training_management.training.participation.participant.TrainingParticipation;
import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationRequest;
import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TrainingParticipationMapperServiceImpl implements TrainingParticipationMapperService {

    private final ParticipantService participantService;
    private final StatusService statusService;

    @Override
    public TrainingParticipationResponse toDTO(TrainingParticipation trainingParticipation) {
        return new TrainingParticipationResponse(
                trainingParticipation.getId(),
                participantService.toCompactDTO(trainingParticipation.getParticipant()),
                trainingParticipation.getStartTime(),
                trainingParticipation.getEndTime(),
                statusService.toCompactDTO(trainingParticipation.getStatus()),
                trainingParticipation.getCreatedDate()

        );
    }

    @Override
    public TrainingParticipation toEntity(TrainingParticipationRequest dto) {
        return mapToEntity(new TrainingParticipation(), dto);
    }

    @Override
    public TrainingParticipation toEntity(TrainingParticipation trainingParticipation, TrainingParticipationRequest dto) {
        return mapToEntity(trainingParticipation, dto);
    }

    private TrainingParticipation mapToEntity(TrainingParticipation trainingParticipation, TrainingParticipationRequest dto) {
        trainingParticipation.setParticipant(participantService.getById(dto.participantId()));
        trainingParticipation.setStartTime(dto.startTime());
        trainingParticipation.setEndTime(dto.endTime());
        trainingParticipation.setStatus(statusService.getById(dto.statusId()));
        return trainingParticipation;
    }
}
