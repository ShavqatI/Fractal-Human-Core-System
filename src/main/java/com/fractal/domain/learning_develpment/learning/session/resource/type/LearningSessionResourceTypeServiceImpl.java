package com.fractal.domain.learning_develpment.learning.session.resource.type;

import com.fractal.domain.learning_develpment.learning.session.resource.type.dto.LearningSessionResourceTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.type.dto.LearningSessionResourceTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class LearningSessionResourceTypeServiceImpl implements LearningSessionResourceTypeService {

    private final LearningSessionResourceTypeRepository learningSessionResourceTypeRepository;
    @Override
    public LearningSessionResourceType create(LearningSessionResourceTypeRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public LearningSessionResourceType update(Long id, LearningSessionResourceTypeRequest dto) {
        try {
            LearningSessionResourceType learningSessionResourceType = findById(id);
            learningSessionResourceType.setCode(dto.code());
            learningSessionResourceType.setName(dto.name());
            return save(learningSessionResourceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<LearningSessionResourceType> getAll() {
        return learningSessionResourceTypeRepository.findAll();
    }

    @Override
    public LearningSessionResourceType getByCode(String code) {
        return learningSessionResourceTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public LearningSessionResourceType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       learningSessionResourceTypeRepository.delete(findById(id));
    }

    @Override
    public LearningSessionResourceTypeResponse toDTO(LearningSessionResourceType learningSessionResourceType) {
        return new LearningSessionResourceTypeResponse(
                learningSessionResourceType.getId(),
                learningSessionResourceType.getCode(),
                learningSessionResourceType.getName(),
                learningSessionResourceType.getCreatedDate()
        );
    }
    private LearningSessionResourceType toEntity(LearningSessionResourceTypeRequest dto) {
        return LearningSessionResourceType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private LearningSessionResourceType save(LearningSessionResourceType learningSessionResourceType) {
        try {
            return learningSessionResourceTypeRepository.save(learningSessionResourceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LearningSessionResourceType findById(Long id) {
        return learningSessionResourceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
