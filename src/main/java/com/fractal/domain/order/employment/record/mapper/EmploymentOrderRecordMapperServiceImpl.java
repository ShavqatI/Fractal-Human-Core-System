package com.fractal.domain.order.employment.record.mapper;

import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.order.employment.record.EmploymentOrderRecord;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordRequest;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmploymentOrderRecordMapperServiceImpl implements EmploymentOrderRecordMapperService {

    private final EmployeeEmploymentService employmentService;

    @Override
    public EmploymentOrderRecordResponse toDTO(EmploymentOrderRecord record) {
        return new EmploymentOrderRecordResponse(
                record.getId(),
                employmentService.toDTO(record.getEmployment()),
                record.getCreatedDate()
        );
    }

    @Override
    public EmploymentOrderRecord toEntity(EmploymentOrderRecordRequest dto) {
        return mapToEntity(new EmploymentOrderRecord(), dto);
    }

    @Override
    public EmploymentOrderRecord toEntity(EmploymentOrderRecord record, EmploymentOrderRecordRequest dto) {
        return mapToEntity(record, dto);
    }

    private EmploymentOrderRecord mapToEntity(EmploymentOrderRecord record, EmploymentOrderRecordRequest dto) {
        record.setEmployment(employmentService.getById(dto.employmentId()));
        return record;
    }

}
