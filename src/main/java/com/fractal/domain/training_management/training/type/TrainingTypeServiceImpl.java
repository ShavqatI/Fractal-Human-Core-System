package com.fractal.domain.training_management.training.type;

import com.fractal.domain.training_management.training.type.dto.TrainingTypeRequest;
import com.fractal.domain.training_management.training.type.dto.TrainingTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TrainingTypeServiceImpl implements TrainingTypeService {

    private final TrainingTypeRepository trainingTypeRepository;
    @Override
    public TrainingType create(TrainingTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public TrainingType update(Long id, TrainingTypeRequest dto) {
        try {
            TrainingType trainingType = findById(id);
            trainingType.setCode(dto.code());
            trainingType.setName(dto.name());
            return save(trainingType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<TrainingType> getAll() {
        return trainingTypeRepository.findAll();
    }

    @Override
    public TrainingType getByCode(String code) {
        return trainingTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public TrainingType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       trainingTypeRepository.delete(findById(id));
    }

    @Override
    public TrainingTypeResponse toDTO(TrainingType trainingType) {
        return new TrainingTypeResponse(
                trainingType.getId(),
                trainingType.getCode(),
                trainingType.getName(),
                trainingType.getCreatedDate()
        );
    }
    private TrainingType toEntity(TrainingTypeRequest dto) {
        return TrainingType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private TrainingType save(TrainingType trainingType) {
        try {
            return trainingTypeRepository.save(trainingType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private TrainingType findById(Long id) {
        return trainingTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
