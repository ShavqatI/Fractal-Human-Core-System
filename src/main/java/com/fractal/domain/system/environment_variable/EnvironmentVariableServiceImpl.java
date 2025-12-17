package com.fractal.domain.system.environment_variable;

import com.fractal.domain.system.environment_variable.dto.EnvironmentVariableRequest;
import com.fractal.domain.system.environment_variable.dto.EnvironmentVariableResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EnvironmentVariableServiceImpl implements EnvironmentVariableService {

    private final EnvironmentVariableRepository environmentVariableRepository;

    @Override
    public EnvironmentVariable create(EnvironmentVariableRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<EnvironmentVariable> getAll() {
        return environmentVariableRepository.findAll();
    }

    @Override
    public EnvironmentVariable getByCode(String code) {
        return environmentVariableRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with code: " + code + " not found"));
    }

    @Override
    public EnvironmentVariable getById(Long id) {
        return findById(id);
    }

    @Override
    public EnvironmentVariable update(Long id, EnvironmentVariableRequest dto) {
        try {
            EnvironmentVariable environmentVariable = findById(id);
            environmentVariable.setCode(dto.code());
            environmentVariable.setName(dto.name());
            environmentVariable.setValue(dto.value());
            return save(environmentVariable);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        environmentVariableRepository.delete(findById(id));
    }

    @Override
    public EnvironmentVariableResponse toDTO(EnvironmentVariable environmentVariable) {
        return new EnvironmentVariableResponse(
                environmentVariable.getId(),
                environmentVariable.getCode(),
                environmentVariable.getName(),
                environmentVariable.getValue(),
                environmentVariable.getCreatedDate()
        );
    }

    private EnvironmentVariable toEntity(EnvironmentVariableRequest dto) {
        return EnvironmentVariable.builder()
                .code(dto.code())
                .name(dto.name())
                .value(dto.value())
                .build();
    }

    private EnvironmentVariable save(EnvironmentVariable environmentVariable) {
        try {
            return environmentVariableRepository.save(environmentVariable);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EnvironmentVariable findById(Long id) {
        return environmentVariableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with id: " + id + " not found"));
    }

}
