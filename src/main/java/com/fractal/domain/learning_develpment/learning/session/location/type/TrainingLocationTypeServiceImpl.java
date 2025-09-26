package com.fractal.domain.learning_develpment.learning.session.location.type;

import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeResponse;
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
    public LearningLocationType create(LearningLocationTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public LearningLocationType update(Long id, LearningLocationTypeRequest dto) {
        try {
            LearningLocationType learningLocationType = findById(id);
            learningLocationType.setCode(dto.code());
            learningLocationType.setName(dto.name());
            return save(learningLocationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<LearningLocationType> getAll() {
        return trainingLocationTypeRepository.findAll();
    }

    @Override
    public LearningLocationType getByCode(String code) {
        return trainingLocationTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public LearningLocationType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       trainingLocationTypeRepository.delete(findById(id));
    }

    @Override
    public LearningLocationTypeResponse toDTO(LearningLocationType learningLocationType) {
        return new LearningLocationTypeResponse(
                learningLocationType.getId(),
                learningLocationType.getCode(),
                learningLocationType.getName(),
                learningLocationType.getCreatedDate()
        );
    }
    private LearningLocationType toEntity(LearningLocationTypeRequest dto) {
        return LearningLocationType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private LearningLocationType save(LearningLocationType learningLocationType) {
        try {
            return trainingLocationTypeRepository.save(learningLocationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LearningLocationType findById(Long id) {
        return trainingLocationTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
