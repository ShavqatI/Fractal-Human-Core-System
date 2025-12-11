package com.fractal.domain.order.recognition.record.mapper;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponentService;
import com.fractal.domain.order.recognition.record.RecognitionOrderRecord;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordRequest;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RecognitionOrderRecordMapperServiceImpl implements RecognitionOrderRecordMapperService {

    private final EmployeeEmploymentService employmentService;
    private final EmployeeService employeeService;
    private final CompensationComponentService compensationComponentService;

    @Override
    public RecognitionOrderRecordResponse toDTO(RecognitionOrderRecord record) {
        return new RecognitionOrderRecordResponse(
                record.getId(),
                employeeService.toCompactDTO(record.getEmployment().getEmployee()),
                employmentService.toDTO(record.getEmployment()),
                record.getCreatedDate()
        );
    }

    @Override
    public RecognitionOrderRecord toEntity(RecognitionOrderRecordRequest dto) {
        return mapToEntity(new RecognitionOrderRecord(), dto);
    }

    @Override
    public RecognitionOrderRecord toEntity(RecognitionOrderRecord record, RecognitionOrderRecordRequest dto) {
        return mapToEntity(record, dto);
    }

    private RecognitionOrderRecord mapToEntity(RecognitionOrderRecord record, RecognitionOrderRecordRequest dto) {
        record.setEmployment(employmentService.getById(dto.employmentId()));
        record.setCompensationComponent(compensationComponentService.getById(dto.compensationComponentId()));
        return record;
    }

}
