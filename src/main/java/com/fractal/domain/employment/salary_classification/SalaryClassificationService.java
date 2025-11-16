package com.fractal.domain.employment.salary_classification;

import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationCompactResponse;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationRequest;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationResponse;

import java.util.List;

public interface SalaryClassificationService {

    SalaryClassification create(SalaryClassificationRequest dto);

    List<SalaryClassification> getAll();

    SalaryClassification getByCode(String code);

    SalaryClassification getById(Long id);

    SalaryClassification update(Long id, SalaryClassificationRequest dto);

    void deleteById(Long id);

    SalaryClassificationResponse toDTO(SalaryClassification salaryClassification);

    SalaryClassificationCompactResponse toCompactDTO(SalaryClassification salaryClassification);

    SalaryClassification addChild(Long id, SalaryClassificationRequest dto);

    SalaryClassification updateChild(Long id, Long childId, SalaryClassificationRequest dto);

    void deleteChild(Long id, Long childId);
}
