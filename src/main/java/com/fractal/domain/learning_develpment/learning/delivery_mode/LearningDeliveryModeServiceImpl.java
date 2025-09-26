package com.fractal.domain.learning_develpment.learning.delivery_mode;

import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeRequest;
import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeResponse;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class LearningDeliveryModeServiceImpl implements LearningDeliveryModeService {

    private final LearningDeliveryModeRepository learningDeliveryModeRepository;

    @Override
    public LearningDeliveryMode create(LearningDeliveryModeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<LearningDeliveryMode> getAll() {
        return learningDeliveryModeRepository.findAll();
    }

    @Override
    public LearningDeliveryMode getByCode(String code) {
        return learningDeliveryModeRepository.findByCode(code).orElseThrow(()-> new ResourceWithCodeNotFoundException(this,code));
    }

    @Override
    public LearningDeliveryMode getById(Long id) {
        return findById(id);
    }

    @Override
    public LearningDeliveryMode update(Long id, LearningDeliveryModeRequest dto) {
        try {
            LearningDeliveryMode learningDeliveryMode = findById(id);
            learningDeliveryMode.setCode(dto.code());
            learningDeliveryMode.setName(dto.name());
            return save(learningDeliveryMode);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        learningDeliveryModeRepository.delete(findById(id));
    }

    @Override
    public LearningDeliveryModeResponse toDTO(LearningDeliveryMode learningDeliveryMode) {
        return new LearningDeliveryModeResponse(
                learningDeliveryMode.getId(),
                learningDeliveryMode.getCode(),
                learningDeliveryMode.getName(),
                learningDeliveryMode.getCreatedDate()
        );
    }

    private LearningDeliveryMode toEntity(LearningDeliveryModeRequest dto) {
        return LearningDeliveryMode.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private LearningDeliveryMode save(LearningDeliveryMode learningDeliveryMode) {
        try {
            return learningDeliveryModeRepository.save(learningDeliveryMode);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LearningDeliveryMode findById(Long id) {
        return learningDeliveryModeRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
