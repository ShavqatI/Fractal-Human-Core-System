package com.fractal.domain.training_management.training.location.online.platform;

import com.fractal.domain.training_management.training.location.online.platform.dto.OnlinePlatformRequest;
import com.fractal.domain.training_management.training.location.online.platform.dto.OnlinePlatformResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OnlinePlatformServiceImpl implements OnlinePlatformService {

    private final OnlinePlatformRepository onlinePlatformRepository;
    @Override
    public OnlinePlatform create(OnlinePlatformRequest dto) {
       return save(toEntity(dto));
    }

    @Override
    public OnlinePlatform update(Long id, OnlinePlatformRequest dto) {
        try {
            OnlinePlatform onlinePlatform = findById(id);
            onlinePlatform.setCode(dto.code());
            onlinePlatform.setName(dto.name());
            return save(onlinePlatform);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<OnlinePlatform> getAll() {
        return onlinePlatformRepository.findAll();
    }

    @Override
    public OnlinePlatform getByCode(String code) {
        return onlinePlatformRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public OnlinePlatform getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
       onlinePlatformRepository.delete(findById(id));
    }

    @Override
    public OnlinePlatformResponse toDTO(OnlinePlatform onlinePlatform) {
        return new OnlinePlatformResponse(
                onlinePlatform.getId(),
                onlinePlatform.getCode(),
                onlinePlatform.getName(),
                onlinePlatform.getCreatedDate()
        );
    }
    private OnlinePlatform toEntity(OnlinePlatformRequest dto) {
        return OnlinePlatform.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private OnlinePlatform save(OnlinePlatform onlinePlatform) {
        try {
            return onlinePlatformRepository.save(onlinePlatform);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OnlinePlatform findById(Long id) {
        return onlinePlatformRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
