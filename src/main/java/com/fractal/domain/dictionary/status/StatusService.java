package com.fractal.domain.dictionary.status;

import com.fractal.domain.dictionary.status.dto.StatusRequest;
import com.fractal.domain.dictionary.status.dto.StatusResponse;

import java.util.List;

public interface StatusService {

    Status create(StatusRequest dto);
    List<Status> getAll();
    Status getByCode(String code);
    Status getById(Long id);
    Status update(Long id, StatusRequest dto);
    void deleteById(Long id);
    StatusResponse toDTO(Status status);
}
