package com.fractal.domain.training_management.training.participation.trainer.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.training_management.trainer.TrainerService;
import com.fractal.domain.training_management.training.participation.trainer.TrainerAssignment;
import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentRequest;
import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TrainerAssignmentMapperServiceImpl implements TrainerAssignmentMapperService {

    private final TrainerService trainerService;
    private final StatusService statusService;

    @Override
    public TrainerAssignmentResponse toDTO(TrainerAssignment trainerAssignment) {
        return new TrainerAssignmentResponse(
                trainerAssignment.getId(),
                trainerService.toCompactDTO(trainerAssignment.getTrainer()),
                trainerAssignment.getStartTime(),
                trainerAssignment.getEndTime(),
                statusService.toCompactDTO(trainerAssignment.getStatus()),
                trainerAssignment.getCreatedDate()

        );
    }

    @Override
    public TrainerAssignment toEntity(TrainerAssignmentRequest dto) {
        return mapToEntity(new TrainerAssignment(), dto);
    }

    @Override
    public TrainerAssignment toEntity(TrainerAssignment trainerAssignment, TrainerAssignmentRequest dto) {
        return mapToEntity(trainerAssignment, dto);
    }

    private TrainerAssignment mapToEntity(TrainerAssignment trainerAssignment, TrainerAssignmentRequest dto) {
        trainerAssignment.setTrainer(trainerService.getById(dto.trainerId()));
        trainerAssignment.setStartTime(dto.startTime());
        trainerAssignment.setEndTime(dto.endTime());
        trainerAssignment.setStatus(statusService.getById(dto.statusId()));
        return trainerAssignment;
    }
}
