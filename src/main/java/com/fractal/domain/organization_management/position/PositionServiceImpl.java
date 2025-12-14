package com.fractal.domain.organization_management.position;

import com.fractal.component.CurrentUserHolder;
import com.fractal.component.SpringContext;
import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.employment.EmploymentOrder;
import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.position.dto.*;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final DepartmentService departmentService;
    private final StatusService statusService;
    private final GradeService gradeService;


    @Override
    public Position create(PositionRequest dto) {
        var position = toEntity(dto);
        position.setCode(generateCode());
        return save(position);
    }

    @Override
    public void create(List<PositionRequest> dto) {
        dto.forEach(r-> create(r));
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
            position.setName(dto.name());
            position.setDescription(dto.description());
            position.setDepartment(departmentService.getById(dto.departmentId()));
            position.setGrade(dto.gradeId() != null ? Optional.of(gradeService.getById(dto.gradeId())).orElse(null) : null);
            position.setSupervisory(dto.supervisory());
            position.setOpenDate(dto.openDate());
            position.setOpenReason(dto.openReason());
            position.setCloseDate(dto.closeDate());
            position.setCloseReason(dto.closeReason());
            return save(position);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public Position close(Long id, PositionCloseRequest dto) {
        try {
            var currentUserHolder = SpringContext.getBean(CurrentUserHolder.class);
            Position position = findById(id);
            position.setCloseDate(dto.closeDate());
            position.setCloseReason(dto.closeReason());
            position.setClosedUser(currentUserHolder.get());
            position.setStatus(statusService.getByCode("CLOSE"));
            return save(position);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    public Position cancel(Long id, PositionCancelRequest dto) {
        try {
            Position position = findById(id);
            position.setCancelDate(LocalDate.now());
            position.setCancelReason(dto.reason());
            position.setCanceledUser(SpringContext.getBean(CurrentUserHolder.class).get());
            position.setStatus(statusService.getByCode("CANCELED"));
            return save(position);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        positionRepository.delete(findById(id));
    }

    @Override
    public Position review(Long id) {
        var position = getById(id);
        if (position.getStatus().getCode().equals("CREATED")) {
             position.setReviewedDate(LocalDateTime.now());
             position.setReviewedUser(SpringContext.getBean(CurrentUserHolder.class).get());
             position.setStatus(statusService.getByCode("REVIEWED"));
            return save(position);
        } else {
            throw new ResourceStateException("The status is not valid is: " + position.getStatus().getName());
        }
    }

    @Override
    public Position approve(Long id) {
        var position = getById(id);
        if (position.getStatus().getCode().equals("REVIEWED")) {
            position.setApprovedDate(LocalDateTime.now());
            position.setApprovedUser(SpringContext.getBean(CurrentUserHolder.class).get());
            position.setStatus(statusService.getByCode("APPROVED"));
            return save(position);
        } else {
            throw new ResourceStateException("The status is not valid is: " + position.getStatus().getName());
        }
    }
    @Override
    public PositionResponse toDTO(Position position) {
        return new PositionResponse(
                position.getId(),
                position.getName(),
                position.getDescription(),
                Optional.ofNullable(position.getDepartment())
                        .map(departmentService::toCompactDTO)
                        .orElse(null),
                Optional.ofNullable(position.getGrade())
                        .map(gradeService::toCompactDTO)
                        .orElse(null),
                position.getSupervisory(),
                position.getOpenDate(),
                position.getOpenReason(),
                position.getCloseDate(),
                position.getCloseReason(),
                position.getCancelDate(),
                position.getCancelReason(),
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

    @Override
    public Position getSupervisor(Long id) {
        var position  = getById(id);
        return positionRepository.findActiveSupervisor(position.getDepartment().getId()).orElseThrow(()-> new ResourceNotFoundException("Supervisor position for department id: " + position.getDepartment().getId() + " not found"));
    }

    @Override
    public Position getSupervisor(Department department) {
        return positionRepository.findActiveSupervisor(department.getId()).orElseThrow(()-> new ResourceNotFoundException("Supervisor position for department id: " + department.getId() + " not found"));
    }

    private Position toEntity(PositionRequest dto) {
        return Position.builder()
                .name(dto.name())
                .description(dto.description())
                .department(dto.departmentId() != null ? Optional.of(departmentService.getById(dto.departmentId())).orElse(null): null)
                .grade(dto.gradeId() != null ? Optional.of(gradeService.getById(dto.gradeId())).orElse(null) : null)
                .supervisory(dto.supervisory())
                .openDate(dto.openDate())
                .openReason(dto.openReason())
                .closeDate(dto.closeDate())
                .closeReason(dto.closeReason())
                .status(statusService.getByCode("CREATED"))
                .build();
    }

    private Position save(Position position) {
        try {
            return positionRepository.save(position);

        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Position findById(Long id) {
        return positionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position with id: " + id + " not found"));
    }

    private Position findByCode(String code) {
        return positionRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Position with code : " + code + " not found"));
    }

    private String generateCode() {
        var position = positionRepository.findFirstByOrderByIdDesc();
        if (position.isPresent())
            return "POSITION_" + (position.get().getId() + 1);
        else return "POSITION_" + 1;

    }
}
