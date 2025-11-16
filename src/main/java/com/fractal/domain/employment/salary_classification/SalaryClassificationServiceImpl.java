package com.fractal.domain.employment.salary_classification;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationCompactResponse;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationRequest;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;


@Service
@RequiredArgsConstructor
class SalaryClassificationServiceImpl implements SalaryClassificationService {

    private final SalaryClassificationRepository salaryClassificationRepository;
    private final StatusService statusService;


    @Override
    public SalaryClassification create(SalaryClassificationRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<SalaryClassification> getAll() {
        return salaryClassificationRepository.findAll();
    }

    @Override
    public SalaryClassification getByCode(String code) {
        return salaryClassificationRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Salary Classification with code: " + code + " not found"));
    }

    @Override
    public SalaryClassification getById(Long id) {
        return findById(id);
    }

    @Override
    public SalaryClassification update(Long id, SalaryClassificationRequest dto) {
        try {
            SalaryClassification salaryClassification = findById(id);
            salaryClassification.setCode(dto.code());
            salaryClassification.setName(dto.name());
            salaryClassification.setStatus(statusService.getById(dto.statusId()));
            dto.children().forEach(salaryClassificationRequest -> salaryClassification.addChild(toEntity(salaryClassificationRequest)));
            return save(salaryClassification);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        salaryClassificationRepository.delete(findById(id));
    }

    @Override
    public SalaryClassificationResponse toDTO(SalaryClassification salaryClassification) {
        return new SalaryClassificationResponse(
                salaryClassification.getId(),
                salaryClassification.getCode(),
                salaryClassification.getName(),
                Optional.ofNullable(salaryClassification.getParent())
                        .map(SalaryClassification::getName)
                        .orElse(null),
                Optional.ofNullable(salaryClassification.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(salaryClassification.getStatus()),
                salaryClassification.getCreatedDate()
        );
    }

    @Override
    public SalaryClassificationCompactResponse toCompactDTO(SalaryClassification salaryClassification) {
        return new SalaryClassificationCompactResponse(
                salaryClassification.getId(),
                salaryClassification.getCode(),
                salaryClassification.getName()
        );
    }

    private SalaryClassification toEntity(SalaryClassificationRequest dto) {
        var separationReason = SalaryClassification.builder()
                .code(dto.code())
                .name(dto.name())
                .status(statusService.getById(dto.statusId()))
                .build();
        dto.children().forEach(salaryClassificationRequest -> separationReason.addChild(toEntity(salaryClassificationRequest)));
        return separationReason;
    }

    private SalaryClassification save(SalaryClassification salaryClassification) {
        try {
            return salaryClassificationRepository.save(salaryClassification);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private SalaryClassification findById(Long id) {
        return salaryClassificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salary Classification with id: " + id + " not found"));
    }

    @Override
    public SalaryClassification addChild(Long id, SalaryClassificationRequest dto) {
        var separationReasonType = findById(id);
        separationReasonType.addChild(toEntity(dto));
        return save(separationReasonType);
    }

    @Override
    public SalaryClassification updateChild(Long id, Long childId, SalaryClassificationRequest dto) {
        var separationReasonType = findById(id);
        var child = separationReasonType.getChildren().stream().filter(ch -> ch.getId().equals(childId)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Child with id: " + childId + " not found"));
        update(child.getId(), dto);
        return save(separationReasonType);
    }

    @Override
    public void deleteChild(Long id, Long childId) {
        var separationReasonType = findById(id);
        var child = separationReasonType.getChildren().stream().filter(ch -> ch.getId().equals(childId)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Child with id: " + childId + " not found"));
        separationReasonType.removeChild(child);
        save(separationReasonType);
    }

}
