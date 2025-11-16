package com.fractal.domain.learning_develpment.learning.platform.type;

import com.fractal.domain.learning_develpment.learning.platform.type.dto.OnlinePlatformTypeRequest;
import com.fractal.domain.learning_develpment.learning.platform.type.dto.OnlinePlatformTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OnlinePlatformTypeServiceImpl implements OnlinePlatformTypeService {

    private final OnlinePlatformTypeRepository onlinePlatformTypeRepository;

    @Override
    public OnlinePlatformType create(OnlinePlatformTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public OnlinePlatformType update(Long id, OnlinePlatformTypeRequest dto) {
        try {
            OnlinePlatformType onlinePlatformType = findById(id);
            onlinePlatformType.setCode(dto.code());
            onlinePlatformType.setName(dto.name());
            return save(onlinePlatformType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<OnlinePlatformType> getAll() {
        return onlinePlatformTypeRepository.findAll();
    }

    @Override
    public OnlinePlatformType getByCode(String code) {
        return onlinePlatformTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public OnlinePlatformType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
        onlinePlatformTypeRepository.delete(findById(id));
    }

    @Override
    public OnlinePlatformTypeResponse toDTO(OnlinePlatformType onlinePlatformType) {
        return new OnlinePlatformTypeResponse(
                onlinePlatformType.getId(),
                onlinePlatformType.getCode(),
                onlinePlatformType.getName(),
                onlinePlatformType.getCreatedDate()
        );
    }

    private OnlinePlatformType toEntity(OnlinePlatformTypeRequest dto) {
        return OnlinePlatformType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private OnlinePlatformType save(OnlinePlatformType onlinePlatformType) {
        try {
            return onlinePlatformTypeRepository.save(onlinePlatformType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OnlinePlatformType findById(Long id) {
        return onlinePlatformTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
