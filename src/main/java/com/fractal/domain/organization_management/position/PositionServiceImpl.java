package com.fractal.domain.organization_management.position;

import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.position.dto.PositionCreate;
import com.fractal.domain.organization_management.position.dto.PositionResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final DepartmentService departmentService;

    @Override
    public Position create(PositionCreate dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position getByCode(String code) {
        return findByCode(code);
    }

    @Override
    public Position getById(Long id) {
        return findById(id);
    }

    @Override
    public Position update(Long id, PositionCreate dto) {
        try {
            Position position = findById(id);
            position.setCode(dto.code());
            position.setName(dto.name());
            position.setDescription(dto.description());
            position.setDepartment(departmentService.getByCode(dto.department()));
            return save(position);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      positionRepository.delete(findById(id));
    }

    @Override
    public PositionResponse toDTO(Position position) {
        return new PositionResponse(
                position.getId(),
                position.getCode(),
                position.getName(),
                position.getDescription(),
                position.getDepartment().getName(),
                position.getCreatedDate()
        );
    }
    private Position toEntity(PositionCreate dto) {
        return Position.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .department(departmentService.getByCode(dto.department()))
                .build();
    }

    private Position save(Position position) {
        try {
            return positionRepository.save(position);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Position findById(Long id) {
        return positionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Position with id: " + id + " not found"));
    }
    private Position findByCode(String code) {
        return positionRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Position with code : " + code + " not found"));
    }



}
