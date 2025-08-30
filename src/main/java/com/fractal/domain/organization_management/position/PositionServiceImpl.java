package com.fractal.domain.organization_management.position;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;
import com.fractal.domain.organization_management.position.dto.PositionRequest;
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
    private final StatusService statusService;
    private final GradeService gradeService;

    @Override
    public Position create(PositionRequest dto) {
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
    public Position update(Long id, PositionRequest dto) {
        try {
            Position position = findById(id);
            position.setCode(dto.code());
            position.setName(dto.name());
            position.setDescription(dto.description());
            position.setDepartment(departmentService.getById(dto.departmentId()));
            position.setStatus(statusService.getById(dto.statusId()));
            position.setGrade(gradeService.getById(dto.gradeId()));
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
                departmentService.toCompactDTO(position.getDepartment()),
                gradeService.toCompactDTO(position.getGrade()),
                position.getOpenDate(),
                position.getOpenReason(),
                position.getCloseDate(),
                position.getCloseReason(),
                statusService.toCompactDTO(position.getStatus()),
                position.getCreatedDate()
        );
    }

    @Override
    public PositionCompactResponse toCompactDTO(Position position) {
        return new PositionCompactResponse(
                position.getId(),
                position.getCode(),
                position.getName()
        );
    }

    private Position toEntity(PositionRequest dto) {
        return Position.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .department(departmentService.getById(dto.departmentId()))
                .openDate(dto.openDate())
                .openReason(dto.openReason())
                .closeDate(dto.closeDate())
                .closeReason(dto.closeReason())
                .status(statusService.getById(dto.statusId()))
                .grade(gradeService.getById(dto.gradeId()))
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
