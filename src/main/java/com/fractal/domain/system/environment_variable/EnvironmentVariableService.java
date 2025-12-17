package com.fractal.domain.system.environment_variable;

import com.fractal.domain.system.environment_variable.dto.EnvironmentVariableRequest;
import com.fractal.domain.system.environment_variable.dto.EnvironmentVariableResponse;

import java.util.List;

public interface EnvironmentVariableService {

    EnvironmentVariable create(EnvironmentVariableRequest dto);

    List<EnvironmentVariable> getAll();

    EnvironmentVariable getByCode(String code);

    EnvironmentVariable getById(Long id);

    EnvironmentVariable update(Long id, EnvironmentVariableRequest dto);

    void deleteById(Long id);

    EnvironmentVariableResponse toDTO(EnvironmentVariable environmentVariable);
}
