package com.fractal.domain.training_management.trainer.internal;

import com.fractal.domain.training_management.trainer.Trainer;
import com.fractal.domain.training_management.trainer.TrainerService;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerRequest;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerResponse;
import com.fractal.domain.training_management.trainer.internal.mapper.InternalTrainerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
class InternalTrainerServiceImpl implements InternalTrainerService, TrainerService {

    private final InternalTrainerRepository trainerRepository;
    private final InternalTrainerMapperService mapperService;

    @Override
    @Transactional
    public InternalTrainer create(InternalTrainerRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InternalTrainer> getAll() {
        return trainerRepository.findAll();
    }

    @Override
    public InternalTrainer getById(Long id) {
        return findById(id);
    }

    @Override
    public TrainerCompactResponse toCompactDTO(Trainer trainer) {
        return mapperService.toCompactDTO(trainer);
    }

    @Override
    public InternalTrainer update(Long id, InternalTrainerRequest dto) {
        try {
            InternalTrainer trainer = mapperService.toEntity(findById(id),dto);
            return save(trainer);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      trainerRepository.delete(findById(id));
    }

    @Override
    public InternalTrainerResponse toDTO(InternalTrainer trainer) {
        return mapperService.toDTO(trainer);
    }

    @Override
    public InternalTrainerCompactResponse toCompactDTO(InternalTrainer trainer) {
        return mapperService.toCompactDTO(trainer);
    }


    private InternalTrainer save(InternalTrainer trainer) {
        try {
            return trainerRepository.save(trainer);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InternalTrainer findById(Long id) {
        return trainerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Internal Trainer with id: " + id + " not found"));
    }
}
