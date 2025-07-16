package com.fractal.domain.dictionary.status;

import com.fractal.domain.dictionary.status.category.StatusCategoryService;
import com.fractal.domain.dictionary.status.dto.StatusRequest;
import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final StatusCategoryService statusCategoryService;
    @Override
    public Status create(StatusRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status getByCode(String code) {
        return statusRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Status with code: " + code + " not found"));

    }

    @Override
    public Status getById(Long id) {
        return findById(id);
    }

    @Override
    public Status update(Long id, StatusRequest dto) {
        try {
            Status status = findById(id);
            status.setCode(dto.code());
            status.setName(dto.name());
            status.setStatusCategory(statusCategoryService.getByCode(dto.statusCategory()));
            status.setDescription(dto.description());
            return save(status);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       statusRepository.delete(findById(id));
    }

    @Override
    public StatusResponse toDTO(Status status) {
        return new StatusResponse(
                status.getId(),
                status.getCode(),
                status.getName(),
                statusCategoryService.toDTO(status.getStatusCategory()),
                status.getDescription(),
                status.getCreatedDate()
        );
    }

    private Status toEntity(StatusRequest dto) {
        return Status.builder()
                .code(dto.code())
                .name(dto.name())
                .statusCategory(statusCategoryService.getByCode(dto.statusCategory()))
                .description(dto.description())
                .build();
    }

    private Status save(Status status) {
        try {
            return statusRepository.save(status);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Status findById(Long id) {
        return statusRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Status with id: " + id + " not found"));
    }

}
