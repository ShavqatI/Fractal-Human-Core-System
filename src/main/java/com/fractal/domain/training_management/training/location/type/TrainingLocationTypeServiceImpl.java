package com.fractal.domain.training_management.training.location.type;

import com.fractal.domain.training_management.training.location.type.dto.TrainingLocationTypeRequest;
import com.fractal.domain.training_management.training.location.type.dto.TrainingLocationTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TrainingLocationTypeServiceImpl implements TrainingLocationTypeService {

    private final TrainingLocationTypeRepository trainingLocationTypeRepository;
    @Override
    public TrainingLocationType create(TrainingLocationTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public TrainingLocationType update(Long id, TrainingLocationTypeRequest dto) {
        try {
            TrainingLocationType trainingLocationType = findById(id);
            trainingLocationType.setCode(dto.code());
            trainingLocationType.setName(dto.name());
            return save(trainingLocationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<TrainingLocationType> getAll() {
        return trainingLocationTypeRepository.findAll();
    }

    @Override
    public TrainingLocationType getByCode(String code) {
        return trainingLocationTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public TrainingLocationType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       trainingLocationTypeRepository.delete(findById(id));
    }

    @Override
    public TrainingLocationTypeResponse toDTO(TrainingLocationType trainingLocationType) {
        return new TrainingLocationTypeResponse(
                trainingLocationType.getId(),
                trainingLocationType.getCode(),
                trainingLocationType.getName(),
                trainingLocationType.getCreatedDate()
        );
    }
    private TrainingLocationType toEntity(TrainingLocationTypeRequest dto) {
        return TrainingLocationType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private TrainingLocationType save(TrainingLocationType trainingLocationType) {
        try {
            return trainingLocationTypeRepository.save(trainingLocationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private TrainingLocationType findById(Long id) {
        return trainingLocationTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
