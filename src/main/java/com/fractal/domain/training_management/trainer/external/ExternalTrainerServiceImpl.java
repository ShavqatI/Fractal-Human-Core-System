package com.fractal.domain.training_management.trainer.external;

import com.fractal.domain.training_management.trainer.Trainer;
import com.fractal.domain.training_management.trainer.TrainerService;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerRequest;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerResponse;
import com.fractal.domain.training_management.trainer.external.mapper.ExternalTrainerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ExternalTrainerServiceImpl implements ExternalTrainerService, TrainerService {

    private final ExternalTrainerRepository trainerRepository;
    private final ExternalTrainerMapperService mapperService;

    @Override
    @Transactional
    public ExternalTrainer create(ExternalTrainerRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<ExternalTrainer> getAll() {
        return trainerRepository.findAll();
    }

    @Override
    public ExternalTrainer getById(Long id) {
        return findById(id);
    }



    @Override
    @Transactional
    public ExternalTrainer update(Long id, ExternalTrainerRequest dto) {
        try {
            ExternalTrainer trainer = mapperService.toEntity(findById(id),dto);
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
    public ExternalTrainerResponse toDTO(ExternalTrainer trainer) {
        return mapperService.toDTO(trainer);
    }

    @Override
    public ExternalTrainerCompactResponse toCompactDTO(ExternalTrainer trainer) {
        return mapperService.toCompactDTO(trainer);
    }

    @Override
    public TrainerCompactResponse toCompactDTO(Trainer trainer) {
        return mapperService.toCompactDTO(trainer);
    }


    @Override
    @Transactional
    public ExternalTrainer save(ExternalTrainer trainer) {
        try {
            return trainerRepository.save(trainer);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ExternalTrainer findById(Long id) {
        return trainerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("External Trainer with id: " + id + " not found"));
    }
}
