package com.fractal.domain.training_management.training.resource.type;

import com.fractal.domain.training_management.training.resource.type.dto.TrainingResourceTypeRequest;
import com.fractal.domain.training_management.training.resource.type.dto.TrainingResourceTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TrainingResourceTypeServiceImpl implements TrainingResourceTypeService {

    private final TrainingResourceTypeRepository trainingResourceTypeRepository;
    @Override
    public TrainingResourceType create(TrainingResourceTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public TrainingResourceType update(Long id, TrainingResourceTypeRequest dto) {
        try {
            TrainingResourceType trainingResourceType = findById(id);
            trainingResourceType.setCode(dto.code());
            trainingResourceType.setName(dto.name());
            return save(trainingResourceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<TrainingResourceType> getAll() {
        return trainingResourceTypeRepository.findAll();
    }

    @Override
    public TrainingResourceType getByCode(String code) {
        return trainingResourceTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public TrainingResourceType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       trainingResourceTypeRepository.delete(findById(id));
    }

    @Override
    public TrainingResourceTypeResponse toDTO(TrainingResourceType trainingResourceType) {
        return new TrainingResourceTypeResponse(
                trainingResourceType.getId(),
                trainingResourceType.getCode(),
                trainingResourceType.getName(),
                trainingResourceType.getCreatedDate()
        );
    }
    private TrainingResourceType toEntity(TrainingResourceTypeRequest dto) {
        return TrainingResourceType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private TrainingResourceType save(TrainingResourceType trainingResourceType) {
        try {
            return trainingResourceTypeRepository.save(trainingResourceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private TrainingResourceType findById(Long id) {
        return trainingResourceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
